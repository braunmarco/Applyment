package de.braun;

import de.braun.service.IImportService;
import de.braun.service.ImportService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class ServiceBean implements Serializable {
    private static final Logger logger = Logger.getLogger(ServiceBean.class.getName());
    private String filename;
    private Part uploadFile;

    public void importData() {

        if (uploadFile != null && uploadFile.getSize() > 0) {
            filename = Paths.get(uploadFile.getSubmittedFileName()).getFileName().toString();

            logger.info("import json file with filename" + filename);
            IImportService importService = new ImportService();
            try {
                InputStream in = uploadFile.getInputStream();
                importService.importCurriculumn(in);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /*try {
            if (uploadFile != null) {
                filename = Paths.get(uploadFile.getSubmittedFileName()).getFileName().toString();
                try (InputStream input = uploadFile.getInputStream()) {
                    fileContents = input.readAllBytes();
                } catch (IOException e) {
                    // Show faces message?
                }
                logger.info("filename: " + filename);

                if (filename != null) {
                    //TODO check for json file
                    logger.info("import json file with filename" + filename);
                    IImportService importService = new ImportService();
                    importService.importCurriculumn(filename);
                } else {
                    logger.info("no filename was specified!");
                }
            } else {
                logger.info("No file was selected");
            }

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    public void updateFilename() {
        if (uploadFile != null) {
            filename = Paths.get(uploadFile.getSubmittedFileName()).toFile().getAbsolutePath();
            logger.info("filename: " + filename);
        } else {
            logger.info("No file was selected");
        }
    }

    public String back() {
        return "index.xhtml?faces-redirect=true";
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Part getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(Part uploadFile) {
        this.uploadFile = uploadFile;
    }
}
