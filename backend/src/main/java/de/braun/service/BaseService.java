package de.braun.service;

import de.braun.repositories.BaseRepository;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public abstract class BaseService<T> {
    private BaseRepository repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @SuppressWarnings("unchecked")
    public void persist(T entity) {
        repository.openCurrentSessionWithTransaction();
        repository.persist(entity);
        repository.closeCurrentSessionWithTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<T> loadAll() {
        repository.openCurrentSession();
        List<T> result = repository.loadAll();
        repository.closeCurrentSession();

        return result;
    }

    public void update(T entity) {
    }

    public T findOneByCriteria(final DetachedCriteria detachedCriteria) {
        return getAllByCriteria(detachedCriteria).stream().findFirst().get();
    }

    @SuppressWarnings("unchecked")
    public List<T> getAllByCriteria(final DetachedCriteria detachedCriteria) {
        repository.openCurrentSession();
        List<T> result = repository.getAllByCriteria(detachedCriteria);
        repository.closeCurrentSession();

        return result;
    }
}
