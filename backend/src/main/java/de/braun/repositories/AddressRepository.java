package de.braun.repositories;

import de.braun.domain.Address;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class AddressRepository extends BaseRepository<Address> {

    @SuppressWarnings("unchecked")
    public List<Address> loadAll() {
        return getCurrentSession().createQuery("from Address").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Address> getAllByCriteria(final DetachedCriteria detachedCriteria) {
        return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
    }
}
