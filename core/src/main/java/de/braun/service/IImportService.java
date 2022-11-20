package de.braun.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;

public interface IImportService {
    public void importCurriculumn(String filename) throws JAXBException, IOException;

    public void importCurriculumn(InputStream in) throws JAXBException, IOException;
}
