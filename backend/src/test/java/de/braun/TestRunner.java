package de.braun;

import de.braun.entities.Person;
import de.braun.entities.Position;
import de.braun.repositories.PersonService;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class TestRunner {

    @Test
    public void testPersist (){
        PersonService pService = new PersonService();
        Person p = new Person("marco1", "braun");
        List <Position> positions= new ArrayList<>();
        positions.add(new Position("Softwareengineer", "it-novum GmbH", "SAP Connector"));
        p.setPositionList(positions);
        pService.persist(p);

        List<Person> plist = pService.findAll();
        System.out.println("list of person loaded...");
    }
}
