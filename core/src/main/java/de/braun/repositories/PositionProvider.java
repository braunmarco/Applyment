package de.braun.repositories;

import de.braun.service.ICrudService;

import java.util.List;

public class PositionProvider implements ICrudService {

    @Override
    public void persist(Object entity) {
    }

    @Override
    public Object find(Class clazz, Long id) {
        return null;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public List loadAll(Class clazz, String query) {
        return null;
    }
}
