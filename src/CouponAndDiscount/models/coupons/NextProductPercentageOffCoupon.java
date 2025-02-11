package CouponAndDiscount.models.coupons;

import CouponAndDiscount.models.Cart;
import CouponAndDiscount.models.Product;

import java.util.List;

public class NextProductPercentageOffCoupon  extends CouponDecorator {
    private double percentage;

    public NextProductPercentageOffCoupon(Coupon coupon, double percentage) {
        super(coupon);
        this.percentage = percentage;
    }

    @Override
    public double apply(Cart cart) {
        List<Product> products = cart.getProducts();
        if (!products.isEmpty()) {
            Product firstProduct = products.getFirst();
            firstProduct.setPrice(firstProduct.getPrice() - (firstProduct.getPrice() * (percentage / 100)));
        }
        return coupon.apply(cart);
    }
}