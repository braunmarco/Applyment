package de.braun.service;

import de.braun.domain.Person;

public interface IPersonSpecifiedService {
    Person findByEmail(final String email);
}
