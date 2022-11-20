package de.braun.service;

import de.braun.domain.Person;

import java.util.List;

public interface IPersonService {

    Person get(final Long id);

    <T> Person persist(Person entity);

    Person findByEmail(final String email);

    List<Person> get();
}
