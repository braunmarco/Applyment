package de.braun.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public abstract class BaseRepository<T> {
    private Session currentSession;
    private Transaction currentTransaction;

    public BaseRepository() {
    }

    private static SessionFactory getSessionFactory() {
        Configuration config = new Configuration();
        SessionFactory sessionFactory = config.configure().buildSessionFactory();
        return sessionFactory;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();

        return currentSession;
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    protected Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(final Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(final Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(final T entity) {
        Session session = getCurrentSession();
        session.persist(entity);
    }

    public void update(final T entity) {
    }

    public T getOneByCriteria(final DetachedCriteria detachedCriteria) {
        return null;
    }

    public List<T> getAllByCriteria(final DetachedCriteria detachedCriteria) {
        return null;
    }

    public T findByID(final Class<T> entityClass, final Long id) {
        return getCurrentSession().load(entityClass, id);
    }

    public List<T> loadAll() {
        return null;
    }
}