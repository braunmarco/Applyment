package de.braun.service;

import de.braun.domain.Person;
import de.braun.repositories.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import java.util.List;

public class PersonProvider implements IPersonService {
    private BaseDao<Person> personDao = new BaseDao<>();

    @Override
    public Person get(Long id) {
        return null;
    }

    @Override
    public <T> Person persist(Person entity) {
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(Person.class)
                .add(Property.forName("email").eq(email));

        return personDao.findOne(detachedCriteria);
    }

    @Override
    public List<Person> get() {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(Person.class);

        return personDao.loadAll(detachedCriteria);
    }
}
