package de.braun;

import de.braun.domain.*;
import de.braun.service.AddressService;
import de.braun.service.IPersonService;
import de.braun.service.PersonService;
import de.braun.service.PositionService;
import org.junit.Test;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
public class TestRunner {

    @Test
    public void testStorePersonAddress() {
        IPersonService pService = new PersonService();
        AddressService addressService = new AddressService();

        Person p = new Person("marco1", "braun", "braun_marco@gmx.de", "01755944513");
        //Person p = new Person("marco1", "braun", "chaosteam2000@gmx.de", "01755944513");
        Address address = new Address("Turmstrasse", "63", "36124", "Eichenzell", "none");
        Address address2 = new Address("Heinrichstrasse", "47", "36043", "Fulda", "test");

        // store person
        //Person pCheck = pService.getByEmail("chaosteam2000@gmx.de");
        Person pCheck = pService.getByEmail("braun_marco@gmx.de");
        if (pCheck == null) {

            Address a = addressService.find(address);
            if (a == null) {
                p.addAddress(address);
            } else {
                p.addAddress(a);
            }

            Address a2 = addressService.find(address2);
            if (a2 == null) {
                p.addAddress(address2);
            } else {
                p.addAddress(a2);
            }

            pService.persist(p);
        }

        List<Person> plist = pService.loadAll();
        System.out.println("list of person loaded...");
    }

    @Test
    public void testStorePersonPosition() throws ParseException {
        IPersonService pService = new PersonService();
        PositionService positionService = new PositionService();

        // person
        Person p = new Person("marco1", "braun", "braun_marco@gmx.de", "01755944513");

        // position
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date start = df.parse("01122015");
        Date end = df.parse("15022021");
        Position pos = new Position("Softwareengineer", "it-novum GmbH", start, end);

        // store enties
        pService.persist(p);
        positionService.persist(pos);

        List<Person> plist = pService.loadAll();
        System.out.println("list of person loaded...");
    }

    @Test
    public void testPersist() throws ParseException {
        IPersonService pService = new PersonService();
        Person p = new Person("marco1", "braun", "braun_marco@gmx.de", "01755944513");

        List<Position> positions = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date start = df.parse("01122015");
        Date end = df.parse("15022021");
        positions.add(new Position("Softwareengineer", "it-novum GmbH", start, end));

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Turmstrasse", "63", "36124", "Eichenzell", "none"));
        addressList.add(new Address("Heinrichstrasse", "47", "36043", "Fulda", "none"));

        List<Project> projectList = new ArrayList<>();
        List<Technology> technologies = new ArrayList<>();

        Project project = new Project("SAP-Connector", "test description");
        Technology technology = new Technology("Java", "Java SDK", "1.8");

        technologies.add(technology);
        project.setTechnologies(technologies);
        projectList.add(project);

        // set details
        //p.setPositionList(positions);
        //p.setAddressList(addressList);
        //p.setProjectList(projectList);

        // store person
        //Person pCheck = pService.getByEmail("braun_marco@gmx.de");
        //if (pCheck == null) {
        pService.persist(p);
        //}

        List<Person> plist = pService.loadAll();
        System.out.println("list of person loaded...");
    }

    @Test
    public void testPersist2() throws ParseException {
        IPersonService pService = new PersonService();
        Person p = new Person("marco1", "braun", "chaosteam2000@gmx.de", "01755944513");

        List<Position> positions = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date start = df.parse("01122015");
        Date end = df.parse("15022021");
        positions.add(new Position("Softwareengineer", "it-novum GmbH", start, end));

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Turmstrasse", "63", "36124", "Eichenzell", "none"));
        addressList.add(new Address("Heinrichstrasse", "47", "36043", "Fulda", "none"));

        List<Project> projectList = new ArrayList<>();
        List<Technology> technologies = new ArrayList<>();

        Project project = new Project("SAP-Connector2", "test description");
        Technology technology = new Technology("Java", "Java SDK", "1.8");

        technologies.add(technology);
        project.setTechnologies(technologies);
        projectList.add(project);

        // set details
        //p.setPositionList(positions);
        //p.setAddressList(addressList);
        //p.setProjectList(projectList);


        // store person
        pService.persist(p);

        List<Person> plist = pService.loadAll();
        System.out.println("list of person loaded...");
    }

    /*@Test
    public void testPersist3() throws ParseException {
        IPersonService pService = new PersonService();
        Person p = new Person("marco1", "braun", "golumn@gmx.de", "01755944513");

        List<Position> positions = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date start = df.parse("01122015");
        Date end = df.parse("15022021");
        positions.add(new Position("Softwareengineer", "it-novum GmbH", start, end));

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Turmstrasse", "63", "36124", "Eichenzell", "none"));
        addressList.add(new Address("Heinrichstrasse", "47", "36043", "Fulda", "none"));

        List<Project> projectList = new ArrayList<>();
        List<Technology> technologies = new ArrayList<>();

        Project project = new Project("SAP-Connector2", "test description");
        Technology technology = new Technology("Java", "Java SDK", "1.8");

        technologies.add(technology);
        project.setTechnologies(technologies);
        projectList.add(project);

        // set details
        p.setPositionList(positions);
        p.setAddressList(addressList);
        p.setProjectList(projectList);


        // store person
        pService.persist(p);

        List<Person> plist = pService.loadAll();
        System.out.println("list of person loaded...");
    }*/

    @Test
    public void testReadAll() {
        IPersonService pService = new PersonService();
        List<Person> plist = pService.loadAll();

        Person p = pService.getByEmail("braun_marco@gmx.de");

        System.out.println("finish");
    }

    @Test
    public void testFindbyId() {
        IPersonService pService = new PersonService();
        Person p = pService.findById(28L);

        System.out.println(p.toString());
        System.out.println("finish");
    }
}
