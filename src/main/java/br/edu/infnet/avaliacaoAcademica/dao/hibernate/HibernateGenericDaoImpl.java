package br.edu.infnet.avaliacaoAcademica.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.edu.infnet.avaliacaoAcademica.dao.core.DaoException;
import br.edu.infnet.avaliacaoAcademica.dao.core.IGenericDao;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.util.HibernateSessionFactory;

public class HibernateGenericDaoImpl<E> implements IGenericDao<E> {

    private static final String ERROR_WHILE_CRUD_ENTITY_REPOSITORY_PATTERN_TEXT = "Error while %s entity %s in repository.";
    private static final String ADDING = "adding";
    private static final String REMOVING = "removing";
    private static final String EDITING = "editing";

    private Class<E> clazz;
    private SessionFactory factory;

    public HibernateGenericDaoImpl(Class<E> clazz) {
        this.clazz = clazz;
        this.factory = HibernateSessionFactory.INSTANCE.getSessionFactory();
    }

    @Override
    public void add(E entity) throws DaoException {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(String.format(ERROR_WHILE_CRUD_ENTITY_REPOSITORY_PATTERN_TEXT, ADDING, entity), e);
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(E entity) throws DaoException {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(String.format(ERROR_WHILE_CRUD_ENTITY_REPOSITORY_PATTERN_TEXT, REMOVING, entity), e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(E entity) throws DaoException {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(String.format(ERROR_WHILE_CRUD_ENTITY_REPOSITORY_PATTERN_TEXT, EDITING, entity), e);
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
