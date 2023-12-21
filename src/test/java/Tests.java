import entities.Publication;
import org.junit.Test;
import org.xml.sax.SAXException;
import services.Web;
import services.XML;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void testXMLParser() {
        List<Publication> pubs;
        try {
            pubs = XML.getPubsFromXML("C:\\Users\\zybar\\IdeaProjects\\tt\\src\\main\\resources\\books.xml");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        assertEquals(3, pubs.size());
    }

    @Test
    public void testWebServicePriceSum() {
        List<Publication> pubs;
        try {
            pubs = XML.getPubsFromXML("C:\\Users\\zybar\\IdeaProjects\\tt\\src\\main\\resources\\books.xml");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        assertEquals("66", Web.getSumPrice(pubs));
    }

    @Test
    public void testWebServiceEnginePowerSum() {
        List<Publication> pubs;
        try {
            pubs = XML.getPubsFromXML("C:\\Users\\zybar\\IdeaProjects\\tt\\src\\main\\resources\\books.xml");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        assertEquals("3", Web.getNUmberOfBooks());
    }

}
