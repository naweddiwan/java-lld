package CouponAndDiscount.models.coupons;

import CouponAndDiscount.models.Cart;

// N% off coupon
public class PercentageOffCoupon extends CouponDecorator {
    private final double percentage;

    public PercentageOffCoupon(Coupon coupon, double percentage) {
        super(coupon);
        this.percentage = percentage;
    }

    @Override
    public double apply(Cart cart) {
        double total = coupon.apply(cart);
        return total - (total * (percentage / 100));
    }
}