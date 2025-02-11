package foodDeliverySystem.permissions;

import CouponAndOffer.models.User;

public class UpdateOrderPermission implements Permission{
    private final User user;
    private final Order order;
    private final OrderStatus orderStatus;

    @Override
    public boolean isPermitted() {
        return false;
    }
}
