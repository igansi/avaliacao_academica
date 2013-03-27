package br.edu.infnet.avaliacaoAcademica.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.internal.BootstrapServiceRegistryImpl;

/**
 * Factory para criar uma sessão com o hibernate.
 */
public enum HibernateSessionFactory {
    INSTANCE;

    private SessionFactory session;

    private HibernateSessionFactory() {
        session = new Configuration().configure().buildSessionFactory(new BootstrapServiceRegistryImpl());
    }

    public SessionFactory getSession() {
        return session;
    }
}
