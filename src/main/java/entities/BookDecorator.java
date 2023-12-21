package entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDecorator implements Publication {

    private Book book;

    @Override
    public void setName(String name) {
        book.setName(name);
    }
    @Override
    public String getName() {
        return book.getName();
    }

    @Override
    public void setPrice(double price) {
        book.setPrice(price);
    }
    @Override
    public double getPrice() {
        return book.getPrice();
    }

    @Override
    public void setGenre(String genre) {
        book.setGenre(genre);
    }
    @Override
    public String getGenre() {
        return book.getGenre();
    }

    @Override
    public String getInfo() {
        return book.toString();
    }


}
