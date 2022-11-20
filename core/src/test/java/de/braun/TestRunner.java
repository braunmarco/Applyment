package de.braun;

import de.braun.domain.CurriculumVitae;
import de.braun.domain.Person;
import de.braun.domain.Position;
import de.braun.domain.PositionDetail;
import de.braun.repositories.CurriculumVitaeProvider;
import de.braun.service.PersonProvider;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestRunner {


    @Test
    public void testPersonProvider() {
        PersonProvider personProvider = new PersonProvider();

        List<Person> personList = personProvider.get();

        System.out.println("personlist");
    }

    @Test
    public void testFindAndUpdateCV() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date start = df.parse("06062015");
        Date end = df.parse("10062015");

        Position pos = new Position("Softwareengineer", "Dekra Arbeit GmbH", start, end);
        PositionDetail positionDetail = new PositionDetail("Entwicklung eines Hilfesystems für Izar@Net v.2");

        pos.addPositionDetail(positionDetail);

        CurriculumVitaeProvider cvService = new CurriculumVitaeProvider();
        CurriculumVitae cv = cvService.findByTitle("testcv");
        cv.addPosition(pos);

        //CurriculumVitae updated = baseDao.update(cv);
    }

    /*@Test
    public void testStoreCV() throws ParseException {
        CurriculumVitaeService cvService = new CurriculumVitaeService();

        Address address = new Address("Turmstrasse", "63", "36124", "Eichenzell", "none", AddressType.HOME.ordinal());
        Address address2 = new Address("Heinrichstrasse", "47", "36043", "Fulda", "test", AddressType.HOME_2ND.ordinal());
        Person p = new Person("marco1", "de/braun", "braun_marco@gmx.de", "01755944513");

        // position
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date start = df.parse("01122015");
        Date end = df.parse("15022021");

        Position pos = new Position("Softwareengineer", "Dekra Arbeit GmbH", start, end);
        PositionDetail positionDetail = new PositionDetail("Entwicklung von Kettle Steps zum Serialisieren von SAP-Daten aus SAP R/3 bzw. SAP BW");
        PositionDetail positionDetail1 = new PositionDetail("Betreuung des SAP R/3 bzw. SAP BW Testsystems");

        CurriculumVitae cv = new CurriculumVitae("testcv", p);
        pos.addPositionDetail(positionDetail);
        pos.addPositionDetail(positionDetail1);
        cv.addPosition(pos);

        p.addCurriculumVitae(cv);
        p.addAddress(address);
        p.addAddress(address2);

        cvService.save(cv);
    }

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
    }*/
}
