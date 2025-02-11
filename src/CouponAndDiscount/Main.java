package CouponAndDiscount;

import CouponAndDiscount.models.Cart;
import CouponAndDiscount.models.Product;
import CouponAndDiscount.models.coupons.*;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Shirt", 1000, "Clothing");
        Product p2 = new Product("Pants", 1500, "Clothing");
        Product p3 = new Product("Shoes", 2000, "Footwear");

        // Create cart
        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        // Apply coupons
        Coupon baseCoupon = new BaseCoupon();
        Coupon coupon1 = new PercentageOffCoupon(baseCoupon, 10); // 10% off on total
        Coupon coupon2 = new NextProductPercentageOffCoupon(coupon1, 20); // 20% off on the first product
        Coupon coupon3 = new NthProductTypeDiscountCoupon(coupon2, 2, "Clothing", 30); // 30% off on 2nd Clothing item

        // Calculate net price
        double netPrice = coupon3.apply(cart);
        System.out.println("Net Price after applying coupons: " + netPrice);
    }
}
