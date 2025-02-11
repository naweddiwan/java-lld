package CouponAndDiscount.models.coupons;

import CouponAndDiscount.models.Cart;

// Coupon interface
public interface Coupon {
    double apply(Cart cart);
}
