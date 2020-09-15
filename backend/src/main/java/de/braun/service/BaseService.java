package de.braun.service;

import de.braun.repositories.BaseRepository;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T> {
    final private BaseRepository<T> repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public void persist(T entity) {
        repository.openCurrentSessionWithTransaction();
        repository.persist(entity);
        repository.closeCurrentSessionWithTransaction();
    }

    public T update(T entity) {
        repository.openCurrentSessionWithTransaction();
        repository.update(entity);
        repository.closeCurrentSessionWithTransaction();

        return entity;
    }

    public List<T> loadAll() {
        repository.openCurrentSession();
        List<T> result = repository.loadAll();
        repository.closeCurrentSession();

        return result;
    }


    public T findOneByCriteria(final DetachedCriteria detachedCriteria) {
        final Optional<T> result = getAllByCriteria(detachedCriteria).stream().findFirst();
        return result.isPresent() ? result.get() : null;
    }

    public List<T> getAllByCriteria(final DetachedCriteria detachedCriteria) {
        repository.openCurrentSession();
        List<T> result = repository.getAllByCriteria(detachedCriteria);
        repository.closeCurrentSession();

        return result;
    }

    public T findById(final Class<T> entityClass, final Long id) {
        repository.openCurrentSessionWithTransaction();
        T result = (T) repository.findByID(entityClass, id);
        repository.closeCurrentSessionWithTransaction();

        return result;
    }
}
