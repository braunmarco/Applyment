package de.braun;

import de.braun.service.IImportService;
import de.braun.service.ImportService;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestWebServices {

    @Test
    public void testRSService() throws IOException {
        /*URI baseURI = URI.create("http://localhost:8080/");
        ResourceConfig rc = new ResourceConfig(CurriculumVitaeResource.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseURI, rc);
        System.in.read();*/
    }

    @Test
    public void testImportService() {
        IImportService service = new ImportService();
        try {
            service.importCurriculumn("src/test/resources/cvTest.json");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
