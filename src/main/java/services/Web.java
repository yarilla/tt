package services;

import entities.Publication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Web {
    public static List<Publication> getPub() {
        try {
            return XML.getPubsFromXML("C:\\Users\\zybar\\IdeaProjects\\tt\\src\\main\\resources\\books.xml");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getData(){
        List<Publication> pubList = getPub();
        StringBuilder output = new StringBuilder();
        for (Publication c : pubList) {
            output.append(c.getInfo()).append(";");
        }
        return output.toString();
    }

    public static StringBuilder getHTMLData () {
        String[] booksArray = getData().split(";");
        StringBuilder htmlList = new StringBuilder("<ul>");
        for (String bookInfo : booksArray) {
            String[] bookDetails = bookInfo.split(",");
            String bookName = bookDetails[0].trim();
            String bookPrice = bookDetails[1].trim();
            String bookGenre = bookDetails[2].trim();
            htmlList.append("<li>")
                    .append("Название: ").append(bookName).append(", ")
                    .append("Стоимость: ").append(bookPrice).append(", ")
                    .append("Жанр: ").append(bookGenre)
                    .append("</li>");
        }

        htmlList.append("</ul>");
        return htmlList;
    }
    public static String getSumPrice(List<Publication> transportList) {
        return transportList.stream().map(Publication::getPrice).reduce(Double::sum).get().toString();
    }

    public static String getSumPrice() {
        List<Publication> pubList = getPub();
        return pubList.stream().map(Publication::getPrice).reduce(Double::sum).get().toString();
    }


    public static String getNUmberOfBooks() {
        return Integer.toString(getPub().size());
    }




}
