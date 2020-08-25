package de.braun.service;

import de.braun.repositories.BaseRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseService<T> {
    private BaseRepository repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public void persist(T entity) {
        repository.openCurrentSessionWithTransaction();
        repository.persist(entity);
        repository.closeCurrentSessionWithTransaction();
    }

    public List<T> loadAll() {
        repository.openCurrentSession();
        List<T> result = repository.loadAll();
        repository.closeCurrentSession();

        return result;
    }

    public void update(T entity) {
    }

    public T findOneByCriteria(DetachedCriteria detachedCriteria) {
        repository.openCurrentSession();
        T result = (T) repository.getOneByCriteria(detachedCriteria);
        repository.closeCurrentSession();
        return result;
    }

    public List<T> getAllByCriteria(DetachedCriteria detachedCriteria) {
        repository.openCurrentSession();
        List<T> result = repository.getAllByCriteria(detachedCriteria);
        repository.closeCurrentSession();
        return result;
    }
}
