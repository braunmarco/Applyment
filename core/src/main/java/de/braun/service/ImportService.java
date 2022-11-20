package de.braun.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.braun.domain.CurriculumVitae;
import de.braun.repositories.BaseDao;
import de.braun.repositories.CurriculumVitaeProvider;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class ImportService implements IImportService {
    private static final Logger logger = Logger.getLogger(ImportService.class.getName());

    @Override
    public void importCurriculumn(String filename) throws JAXBException, IOException {
        // read curriculumVitae from json-File
        byte[] jsonData = Files.readAllBytes(Paths.get(filename));
        importData(jsonData);
    }

    public void importCurriculumn(InputStream in) throws JAXBException, IOException {
        byte[] bytes = readAllBytes(in);
        importData(bytes);
    }

    private void importData(byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();

        if (data == null || data.length == 0) {
            logger.info("no data");
            return;
        }

        // mapping to curriculumVitae-Class
        CurriculumVitae curriculumVitae = null;
        try {
            curriculumVitae = objectMapper.readValue(data, CurriculumVitae.class);
            // TODO one service to find and store?
            // create service
            ICurriculumVitaeService curriculumVitaeService = new CurriculumVitaeProvider();
            CurriculumVitae cv = curriculumVitaeService.findByTitle(curriculumVitae.getTitle());

            if (cv == null) {
                ICrudService cvService = new BaseDao();
                cvService.persist(curriculumVitae);
            } else {
                logger.info("cv with id: " + cv.getId() + " and title: " + cv.getTitle() + " exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        final int bufLen = 4 * 0x400; // 4KB
        byte[] buf = new byte[bufLen];
        int readLen;
        IOException exception = null;

        try {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                while ((readLen = inputStream.read(buf, 0, bufLen)) != -1)
                    outputStream.write(buf, 0, readLen);

                return outputStream.toByteArray();
            }
        } catch (IOException e) {
            exception = e;
            throw e;
        } finally {
            if (exception == null) inputStream.close();
            else try {
                inputStream.close();
            } catch (IOException e) {
                exception.addSuppressed(e);
            }
        }
    }
}
