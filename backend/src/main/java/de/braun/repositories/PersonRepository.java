package de.braun.repositories;

import de.braun.entities.Person;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class PersonRepository extends BaseRepository<Person> {

    @SuppressWarnings("unchecked")
    public List<Person> loadAll() {
        return getCurrentSession().createCriteria(Person.class).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getAllByCriteria(final DetachedCriteria detachedCriteria) {
        return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
    }
}
