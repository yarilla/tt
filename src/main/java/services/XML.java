package services;


import entities.Book;
import entities.BookDecorator;
import entities.Publication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XML {
    public static List<Publication> getPubsFromXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setIgnoringComments(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);
        Element lib = doc.getDocumentElement();
        List<Book> pubs = new ArrayList<Book>();


        if ("books".equals(lib.getTagName())) {
            NodeList books = lib.getElementsByTagName("book");
            for (int i = 0; i < books.getLength(); ++i) {
                Element book = (Element) books.item(i);
                String name =  book.getElementsByTagName("name").item(0).getTextContent();
                String price = book.getElementsByTagName("price").item(0).getTextContent();
                String genre = book.getElementsByTagName("genre").item(0).getTextContent();
                pubs.add(Book.builder().price(Double.parseDouble(price)).name(name).genre(genre).build());
            }
        }

        List<Publication> bookDecorators = new ArrayList<>();
        pubs.forEach(t -> bookDecorators.add(new BookDecorator(t)));
        return bookDecorators;
    }
}
