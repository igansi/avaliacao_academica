package br.edu.infnet.avaliacaoAcademica.dao.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;

/**
 * Factory para criar uma sessão com o hibernate.
 */
public enum HibernateSessionFactory {
    INSTANCE;

    private SessionFactory session;

    private HibernateSessionFactory() {
        Configuration configuration = new Configuration();
        
        configuration.setProperties(HibernatePropertiesReader.getProperties()).addAnnotatedClass(Student.class);
        session = configuration.buildSessionFactory(
                new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
    }

    public SessionFactory getSessionFactory() {
        return session;
    }
}
