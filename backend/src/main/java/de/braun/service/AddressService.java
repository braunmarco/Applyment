package de.braun.service;

import de.braun.domain.Address;
import de.braun.repositories.AddressRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

public class AddressService extends BaseService<Address> {
    public AddressService() {
        super(new AddressRepository());
    }

    public Address find(final Address address) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(Address.class)
                .add(Property.forName("streetName").eq(address.getStreetName()))
                .add(Property.forName("streetNumber").eq(address.getStreetNumber()))
                .add(Property.forName("postalCode").eq(address.getPostalCode()))
                .add(Property.forName("city").eq(address.getCity()))
                .add(Property.forName("additional").eq(address.getAdditional()));

        return super.findOneByCriteria(detachedCriteria);
    }

    public Address findById(final Long id) {
        return super.findById(Address.class, id);
    }
}