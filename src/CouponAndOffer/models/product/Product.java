package CouponAndOffer.models.product;

import lombok.Getter;

@Getter
public abstract class Product {
    protected String name;
    protected Double price;
    protected ProductType productType;

    Product(){}

    public Product(Double price, ProductType productType, String name) {
        this.price = price;
        this.productType = productType;
        this.name = name;
    }

    public abstract Double getPrice();


}
