package de.braun.service;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import de.braun.domain.Address;
import de.braun.domain.CurriculumVitae;
import de.braun.domain.Person;
import de.braun.domain.Position;
import de.braun.model.AddressType;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Set;

public class PrintService implements IPrintService {
    private final static String DATE_PATTERN = "MM/yyyy";
    private final static String POSITIONS = "positions";
    private final static String SRC = "pdfTemplate.html";
    private final static String POSITION_HEADER = "Berufserfahrung";
    private final static String PERSONAL_HEADER = "Persöhnliche Daten";
    private final static String SRC_IMAGE = "c:/Users/Marco/passfoto.jpg";

    private static PrintService INSTANCE;

    private PrintService() {
    }

    public static PrintService getInstance() {
        if (INSTANCE == null) {
            synchronized (PrintService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PrintService();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public void printCV(final String destination, final CurriculumVitae cv) {
        final Table personalDataTable = createPersonalDataTable(cv.getPerson());
        final Table positionTable = createPositionTable(cv.getPositions());
        final Paragraph p = new Paragraph("Curriculum Vitae");
        try {
            PdfDocument pdf = new PdfDocument(new PdfWriter(destination));
            Document document = new Document(pdf);
            Image image = createImage(SRC_IMAGE);

            // header
            p.setBold();
            p.setFontSize(14F);
            p.setTextAlignment(TextAlignment.CENTER);
            p.setPaddingBottom(20F);

            // add objects
            document.add(p);
            document.add(createImage(SRC_IMAGE));
            document.add(personalDataTable);
            document.add(positionTable);
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image createImage(final String srcImagePath) {
        try {
            Image image = new Image(ImageDataFactory.create(srcImagePath));
            image.setAutoScale(false);
            image.scale(3F, 3F);
            image.setFixedPosition(1, 450, 625, 30);
            return image;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Table createPositionTable(final Set<Position> positions) {
        final SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
        final float[] columnWidth = {200F, 200F};

        Table table = new Table(columnWidth);
        Cell headerCell = createCell(POSITION_HEADER, 0F, createHeaderStyle());
        headerCell.setPaddingTop(20F);
        table.addHeaderCell(headerCell);


        for (Position position : positions) {
            String start = df.format(position.getStart_pos());
            String end = df.format(position.getEnd_pos());

            Cell time = createCell(start + " - " + end, 0F, createCellStyle());
            Cell description = createCell(position.getCompany(), 0F, createCellStyle().setBold());
            Cell positionDetails = createCell(position.getTitle(), 10F, createCellStyle());

            description.add(positionDetails);
            table.addCell(time);
            table.addCell(description);
        }

        return table;
    }

    public Table createPersonalDataTable(final Person person) {
        final float[] columnWidth = {200F, 200F};
        final Address homeAddress = getHomeAddress(person.getAddressList());

        Table table = new Table(columnWidth);

        table.addHeaderCell(createCell(PERSONAL_HEADER, 0F, createHeaderStyle()));

        Cell name = createCell("Name:", 0F, createCellStyle().setBold());
        Cell nameValue = createCell(person.getName() + ", " + person.getSurname(), 0F, createCellStyle());

        Cell address = createCell("Adresse:", 0F, createCellStyle().setBold());

        Cell addressStreetValue = createCell(homeAddress.getStreetName() + " " + homeAddress.getStreetNumber(), 0F, createCellStyle());
        Cell addressCity = createCell(homeAddress.getPostalCode() + " " + homeAddress.getCity(), 0F, createCellStyle());
        addressStreetValue.add(addressCity);

        Cell birthday = createCell("Geburtsdatum:", 0F, createCellStyle().setBold());
        Cell birthdayValue = createCell("03.11.1975", 0F, createCellStyle());

        Cell familyState = createCell("Familienstand:", 0F, createCellStyle().setBold());
        Cell familyStateValue = createCell("ledig", 0F, createCellStyle());

        table.addCell(name);
        table.addCell(nameValue);

        table.addCell(address);
        table.addCell(addressStreetValue);

        table.addCell(birthday);
        table.addCell(birthdayValue);

        table.addCell(familyState);
        table.addCell(familyStateValue);

        return table;
    }

    private Address getHomeAddress(final Set<Address> addresses) {
        return addresses.stream()
                .filter(p -> p.getType() == AddressType.HOME.ordinal())
                .findFirst()
                .orElse(null);
    }

    private Style createHeaderStyle() {
        final Style style = new Style();
        style.setUnderline();
        style.setBold();
        style.setFontSize(14F);

        return style;
    }

    private Style createCellStyle() {
        final Style style = new Style();
        style.setFontSize(11F);

        return style;
    }

    private Cell createCell(final String value, final float padding, final Style style) {
        Paragraph p = new Paragraph(value);
        Cell cell = new Cell();

        p.addStyle(style);
        cell.add(p);
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingLeft(padding);

        return cell;
    }
}