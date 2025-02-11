package CouponAndDiscount.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    String name;
    double price;
    String type;

    public Product(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
