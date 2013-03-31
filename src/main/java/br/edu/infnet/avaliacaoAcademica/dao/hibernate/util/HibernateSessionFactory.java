package br.edu.infnet.avaliacaoAcademica.dao.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Question;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;

/**
 * Factory para criar uma sessão com o hibernate.
 */
public enum HibernateSessionFactory {
    INSTANCE;

    private static final String HIBERNATE_CFG_XML_FILE = "br/edu/infnet/avaliacaoAcademica/xml/hibernate.cfg.xml";

    private SessionFactory session;

    private HibernateSessionFactory() {
        Configuration configuration = new Configuration();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.configure(HIBERNATE_CFG_XML_FILE)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Question.class).getProperties()).buildServiceRegistry();

        session = configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return session;
    }
}
