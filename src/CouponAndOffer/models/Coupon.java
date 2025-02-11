package CouponAndOffer.models;

import lombok.Getter;

import java.util.Date;

@Getter
public class Coupon {
    private int id;
    private String code;
    private Offer offer;

    public boolean isValid(){
        Date currentDate = new Date();
        Date startDate = offer.getValidity().getStartDate();
        Date endDate = offer.getValidity().getEndDate();
        return currentDate.after(startDate) && !currentDate.before(endDate);
    }

}
