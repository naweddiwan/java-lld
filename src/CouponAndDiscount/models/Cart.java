package CouponAndDiscount.models;

import java.util.ArrayList;
import java.util.List;

// Cart class
public class Cart {
    List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(p -> p.price).sum();
    }
}