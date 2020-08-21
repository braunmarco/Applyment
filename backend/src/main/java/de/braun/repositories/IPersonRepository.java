package de.braun.repositories;

import de.braun.entities.Person;

import java.util.List;

public interface IPersonRepository {
    void persist (Person p);
    List<Person> loadAll();
}
