package CouponAndOffer.models;

import CouponAndOffer.models.product.Product;

import java.util.List;

public class Cart {
    private User user;
    private List<Product> productList;

    public Double getTotalPrice(){
        return productList
                .stream()
                .reduce(0.0, (sum, product) -> sum + product.getPrice(), Double::sum);
    }
}
