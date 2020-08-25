package de.braun;

import de.braun.entities.Address;
import de.braun.entities.Person;
import de.braun.entities.Position;
import de.braun.service.PersonService;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class TestRunner {

    @Test
    public void testPersist() {
        PersonService pService = new PersonService();
        Person p = new Person("marco1", "braun", "braun_marco@gmx.de", "01755944513");

        List<Position> positions = new ArrayList<>();
        positions.add(new Position("Softwareengineer", "it-novum GmbH", "SAP Connector"));

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Turmstrasse", "63", "36124", "Eichenzell", "none"));
        addressList.add(new Address("Heinrichstrasse", "47", "36043", "Fulda", "none"));

        // set details
        p.setPositionList(positions);
        p.setAddressList(addressList);

        // store person
        pService.persist(p);

        List<Person> plist = pService.loadAll();
        System.out.println("list of person loaded...");
    }

    @Test
    public void testReadAll(){
        PersonService pService = new PersonService();
        List<Person> plist = pService.loadAll();
    }
}
