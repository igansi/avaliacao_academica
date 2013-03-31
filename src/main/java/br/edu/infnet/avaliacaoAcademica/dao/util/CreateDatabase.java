package br.edu.infnet.avaliacaoAcademica.dao.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.edu.infnet.avaliacaoAcademica.dao.core.DaoException;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.StudentDao;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.StudentCapability;
import br.edu.infnet.avaliacaoAcademica.dao.jbdc.util.JbdcConnectionFactory;

/**
 * Cria a base de dados baseado nas configurações do hibernate.
 */
public class CreateDatabase {

    private static final String DELIMITER = ";";
    private static final String HIBERNATE_CFG_XML_FILE = "br/edu/infnet/avaliacaoAcademica/xml/hibernate.cfg.xml";
    private static final String JBDC_DATABASE_SETUP = "br/edu/infnet/avaliacaoAcademica/dao/jbdc/setupJbdc.sql";

    public static void main(String[] args) {
        setupDatabaseFromHibernate();
        setupDatabaseFromJbdc();
    }

    /**
     * Cria a base de dados baseado no arquivo de SQL a ser execuado pelo JBDC.
     */
    private static void setupDatabaseFromJbdc() {
        Statement currentStatement = null;
        File file = new File(CreateDatabase.class.getClassLoader().getResource(JBDC_DATABASE_SETUP).getFile());
        Connection connection = JbdcConnectionFactory.INSTANCE.getConnection();
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(file).useDelimiter(DELIMITER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNext()) {
            String rawStatement = scanner.next() + DELIMITER;

            try {
                currentStatement = connection.createStatement();
                currentStatement.execute(rawStatement);
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } finally {
                // Release resources
                if (currentStatement != null) {
                    try {
                        currentStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                currentStatement = null;
            }
        }
    }

    /**
     * Cria a base de dados baseado no arquivo de configuração do Hibernate.
     */
    private static void setupDatabaseFromHibernate() {
        Configuration config = getConfiguration();
        SchemaExport schema = new SchemaExport(config);
        StudentDao dao = new StudentDao();

        schema.create(true, true);
        try {
            dao.add(buildStudent());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        
    }

    private static Student buildStudent() {
        Student administrator = new Student();
        
        administrator.setName("administrador");
        administrator.setEmail("administrador@admin.com.br");
        administrator.setLogin("admin");
        administrator.setPassword("admin");
        administrator.setCapability(StudentCapability.ADMINISTRATOR.ordinal());
        return administrator;
    }

    private static Configuration getConfiguration() {
        Configuration config = new Configuration();

        config.configure(HIBERNATE_CFG_XML_FILE).addAnnotatedClass(Student.class);
        return config;
    }
}
