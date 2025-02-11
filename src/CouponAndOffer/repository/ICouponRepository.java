package CouponAndOffer.repository;

import CouponAndOffer.models.Coupon;

public interface ICouponRepository {
    void create(Coupon coupon);
    Coupon getCouponByCode(String couponCode);
}
