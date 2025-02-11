package CouponAndDiscount.models.coupons;

import CouponAndDiscount.models.Cart;

// Abstract decorator class
abstract class CouponDecorator implements Coupon {
    protected Coupon coupon;

    public CouponDecorator(Coupon coupon) {
        this.coupon = coupon;
    }

    public abstract double apply(Cart cart);
}
