package CouponAndOffer.services;

import CouponAndOffer.models.Cart;
import CouponAndOffer.models.Coupon;
import CouponAndOffer.repository.ICouponRepository;

public class CouponService {
    private ICouponRepository couponRepository;

    public CouponService(ICouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon createCoupon(Coupon coupon){
        // TODO: add validations
        couponRepository.create(coupon);
        return coupon;
    }

    public Double applyCoupon(final Cart cart, String couponCode){
        Coupon coupon = couponRepository.getCouponByCode(couponCode);
        Double totalCartPrice = cart.getTotalPrice();

        // 1. Check if coupon is valid
        if(!coupon.isValid()){
            throw new RuntimeException("Invalid Coupon");
        }
        // 2. Check if coupon is applicable based on the car items



        // 3. Apply coupon
        return 0.0;

    }
}
