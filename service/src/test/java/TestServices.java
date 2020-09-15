import de.braun.domain.CurriculumVitae;
import de.braun.service.CurriculumVitaeService;
import org.junit.Test;

public class TestServices {
    @Test
    public void testPrintCV() {
        IPrintService printService = PrintService.getInstance();
        CurriculumVitaeService cvService = new CurriculumVitaeService();
        CurriculumVitae cv = cvService.find("testcv");
        printService.printCV("c:/Users/Marco/cvpdf.pdf", cv);
    }
}
