package CouponAndOffer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class TimeRange {
    private Date startDate;
    private Date endDate;
}
