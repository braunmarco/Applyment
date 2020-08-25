package de.braun.repositories;

import de.braun.entities.Person;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class PersonRepository extends BaseRepository<Person> {

    public List<Person> loadAll() {
        List<Person> result = getCurrentSession().createCriteria(Person.class).list();
        return result;
    }

    @Override
    public List<Person> getAllByCriteria(DetachedCriteria detachedCriteria) {
        List<Person> pl = detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
        return pl;
    }

    @Override
    public Person getOneByCriteria(DetachedCriteria detachedCriteria) {
        Person p = (Person) detachedCriteria.getExecutableCriteria(getCurrentSession()).uniqueResult();

        return p;
    }
}
