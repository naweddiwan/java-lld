package CouponAndOffer.repository;

import CouponAndOffer.models.Coupon;

import java.util.HashMap;

public class InMemoryCouponRepository  implements  ICouponRepository{
    private final HashMap<String, Coupon> coupons;

    public InMemoryCouponRepository(HashMap<Integer, Coupon> coupons) {
        this.coupons = new HashMap<>();
    }

    @Override
    public void create(Coupon coupon) {
        coupons.put(coupon.getCode(), coupon);
    }

    public Coupon getCouponByCode(String couponCode){
        if(!coupons.containsKey(couponCode)){
            throw new RuntimeException("Coupon Code Not Found");
        }
        return coupons.get(couponCode);
    }

}
