package CouponAndDiscount.models.coupons;

import CouponAndDiscount.models.Cart;
import CouponAndDiscount.models.Product;

import java.util.List;

public class NthProductTypeDiscountCoupon extends CouponDecorator {
    private int nth;
    private String type;
    private double discountPercentage;

    public NthProductTypeDiscountCoupon(Coupon coupon, int nth, String type, double discountPercentage) {
        super(coupon);
        this.nth = nth;
        this.type = type;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double apply(Cart cart) {
        List<Product> products = cart.getProducts();
        int count = 0;
        for (Product product : products) {
            if (product.getType().equals(type)) {
                count++;
                if (count == nth) {
                    product.setPrice(product.getPrice() - (product.getPrice() * (discountPercentage / 100)));
                    break;
                }
            }
        }
        // this coupon is previous class's coupon got in the constructor.
        return coupon.apply(cart);
    }
}