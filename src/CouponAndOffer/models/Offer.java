package CouponAndOffer.models;

import lombok.Getter;

@Getter
public class Offer {
    private int id;
    private OfferType offerType;
    private Double offerPercentage;
    private Double offerFlat;
    private TimeRange validity;
}
