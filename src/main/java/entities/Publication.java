package entities;

public interface Publication {

    void setName(String name);
    String getName();

    void setPrice(double price);
    double getPrice();

    void setGenre(String genre);
    String getGenre();


    String getInfo();

}
