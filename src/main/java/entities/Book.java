package entities;

import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Book implements Publication {
    private String name;
    private double price;
    private String genre;

    @Override
    public String getInfo() {
        return null;
    }
}
