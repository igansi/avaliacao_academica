package br.edu.infnet.avaliacaoAcademica.dao.hibernate.util;

import java.util.Properties;

import org.hibernate.cfg.Configuration;

import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Question;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;

/**
 * Classe auxiliar para ler as propriedades de configurações do Hibernate.
 */
public final class HibernatePropertiesReader {

    public static final String HIBERNATE_DRIVER_CLASS = "hibernate.connection.driver_class";
    public static final String HIBERNATE_CONNECTION_URL = "hibernate.connection.url";
    public static final String HIBERNATE_CONNECTION_USER = "hibernate.connection.username";
    public static final String HIBERNATE_CONNECTION_PASSWORD = "hibernate.connection.password";

    private static final String HIBERNATE_CFG_XML_FILE = "br/edu/infnet/avaliacaoAcademica/xml/hibernate.cfg.xml";

    private static Properties properties;

    private HibernatePropertiesReader() {}
    
    public static final Properties getProperties() {
        if (properties == null) {
            Configuration configuration = new Configuration();
            
            configuration.configure(HIBERNATE_CFG_XML_FILE).addAnnotatedClass(Student.class).addAnnotatedClass(Question.class);
            properties = configuration.getProperties();
        }
        return properties;
    }

}
