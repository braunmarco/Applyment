package de.braun.service;

import de.braun.repositories.BaseRepository;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public abstract class BaseService<T extends Serializable> {
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

    public T getByCriteria(DetachedCriteria detachedCriteria) {
        return null;
    }

    public List<T> getAllByCriteria(DetachedCriteria detachedCriteria) {
        return null;
    }
}
