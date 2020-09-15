package de.braun.repositories;

import de.braun.domain.Person;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

//TODO darf nur sichtbar fuer den service sein
public class PersonRepository extends BaseRepository<Person> {

    @SuppressWarnings("unchecked")
    public List<Person> loadAll() {
        return getCurrentSession().createQuery("from Person").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getAllByCriteria(final DetachedCriteria detachedCriteria) {
        return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
    }
}
