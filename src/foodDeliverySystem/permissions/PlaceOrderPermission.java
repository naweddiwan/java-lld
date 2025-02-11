package foodDeliverySystem.permissions;

public class PlaceOrderPermission implements Permission {

    @Override
    public boolean isPermitted() {
        return false;
    }
}
