package br.edu.infnet.avaliacaoAcademica.hibernate.dao.core;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.edu.infnet.avaliacaoAcademica.hibernate.dao.util.HibernateSessionFactory;

public class GenericDaoImpl<E> implements IGenericDao<E> {

    private Class<E> clazz;
    private SessionFactory factory;

    public GenericDaoImpl(Class<E> clazz) {
        this.clazz = clazz;
        this.factory = HibernateSessionFactory.INSTANCE.getSessionFactory();
    }

    @Override
    public void add(E entity) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(E entity) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(E entity) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E find(int id) {
        Session session = factory.openSession();
        E entity = null;

        try {
            entity = (E) session.get(clazz, Integer.valueOf(id));
        } finally {
            session.close();
        }
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> findAll() {
        return (List<E>) factory.openSession().createCriteria(clazz).list();
    }
}
