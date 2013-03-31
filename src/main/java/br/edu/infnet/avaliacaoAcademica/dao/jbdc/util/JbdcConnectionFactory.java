package br.edu.infnet.avaliacaoAcademica.dao.jbdc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.edu.infnet.avaliacaoAcademica.dao.hibernate.util.HibernatePropertiesReader;

/**
 * Factory para criar uma sessão com o JBDC.
 */
public enum JbdcConnectionFactory {
    INSTANCE;

    private Connection connection;

    private JbdcConnectionFactory() {
        String url = HibernatePropertiesReader.getProperties().getProperty(HibernatePropertiesReader.HIBERNATE_CONNECTION_URL);
        String user = HibernatePropertiesReader.getProperties().getProperty(HibernatePropertiesReader.HIBERNATE_CONNECTION_USER);
        String password =
                HibernatePropertiesReader.getProperties().getProperty(HibernatePropertiesReader.HIBERNATE_CONNECTION_PASSWORD);

        try {
            Class.forName(
                    HibernatePropertiesReader.getProperties().getProperty(HibernatePropertiesReader.HIBERNATE_DRIVER_CLASS));
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
