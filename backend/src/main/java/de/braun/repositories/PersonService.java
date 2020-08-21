package de.braun.repositories;

import de.braun.entities.Person;

import java.util.List;

public class PersonService {
    private static PersonRepository repository;

    public PersonService (){
        repository = new PersonRepository();
    }

    public void persist (Person entity) {
        repository.openCurrentSessionWithTransaction();
        repository.persist(entity);
        repository.closeCurrentSessionWithTransaction();
    }

    public List<Person> findAll () {
        repository.openCurrentSession();
        List <Person> persons = repository.loadAll();
        repository.closeCurrentSession();

        return persons;
    }

    public static PersonRepository getRepository() {
        return repository;
    }
}
