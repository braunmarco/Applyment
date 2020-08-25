package de.braun.service;

import de.braun.entities.Person;
import de.braun.repositories.PersonRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

public class PersonService extends BaseService<Person> {

    public PersonService() {
        super(new PersonRepository());
    }

    public Person getByEmail(final String email) {
        DetachedCriteria detachedCriteria1 = DetachedCriteria
                .forClass(Person.class)
                .add(Property.forName("email").eq(email));

        return super.findOneByCriteria(detachedCriteria1);
    }
}
