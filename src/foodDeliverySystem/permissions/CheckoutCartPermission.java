package foodDeliverySystem.permissions;

public class CheckoutCartPermission implements Permission{
    @Override
    public boolean isPermitted() {
        return false;
    }
}
