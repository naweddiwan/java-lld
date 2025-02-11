package CouponAndDiscount.models.coupons;

import CouponAndDiscount.models.Cart;

public class BaseCoupon implements Coupon {
    @Override
    public double apply(Cart cart) {
        return cart.getTotalPrice();
    }
}
