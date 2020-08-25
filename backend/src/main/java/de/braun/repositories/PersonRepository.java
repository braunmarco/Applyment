package de.braun.repositories;

import de.braun.entities.Person;

import java.util.List;

public class PersonRepository extends BaseRepository<Person> {

    public List<Person> loadAll() {
        List<Person> result = getCurrentSession().createCriteria(Person.class).list();
        return result;
    }
}
