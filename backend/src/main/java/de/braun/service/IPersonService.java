package de.braun.service;

import de.braun.domain.Person;

import java.util.List;

public interface IPersonService {
    Person getByEmail(final String email);

    Person findById(final Long id);

    void persist(Person entity);

    List<Person> loadAll();
}
