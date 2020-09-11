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

    @Override
    public void persist(Person entity) {
        Person person = getByEmail(entity.getEmail());

        // save
        if (person == null) {
            super.persist(entity);
        }
        // update
        else {
            final Long id = person.getId();
            entity.setId(id);
            super.update(entity);
        }
    }

    public Person findById(final Long id) {
        return super.findById(Person.class, id);
    }
}
