
import entities.Publication;
import org.xml.sax.SAXException;
import services.XML;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Publication> pubsList;
        try {
            pubsList = XML.getPubsFromXML("/books.xml");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        pubsList.forEach(p -> System.out.println(p.getInfo()));

    }

}
