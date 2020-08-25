package de.braun.service;

import de.braun.entities.Person;
import de.braun.repositories.PersonRepository;

public class PersonService extends BaseService<Person> {

    public PersonService() {
        super(new PersonRepository());
    }
}
