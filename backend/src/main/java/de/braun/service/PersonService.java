package de.braun.service;

import de.braun.domain.Person;
import de.braun.repositories.PersonRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

public class PersonService extends BaseService<Person> implements IPersonService {

    //todo mittels CDI injecten
    public PersonService() {
        super(new PersonRepository());
    }

    public Person getByEmail(final String email) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(Person.class)
                .add(Property.forName("email").eq(email));

        return super.findOneByCriteria(detachedCriteria);
    }

    @Deprecated
    @Override
    public <T> Person persist(Person entity) {
        if (entity.getId() == null) {
            super.persist(entity);
        } else {
            entity = super.update(entity);
        }

        return entity;
    }

    public Person findById(final Long id) {
        return super.findById(Person.class, id);
    }
}
