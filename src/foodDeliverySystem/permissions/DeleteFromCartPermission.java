package foodDeliverySystem.permissions;

public class DeleteFromCartPermission implements Permission{
    @Override
    public boolean isPermitted() {
        return false;
    }
}
