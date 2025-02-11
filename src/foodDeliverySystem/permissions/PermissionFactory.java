package foodDeliverySystem.permissions;

import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.data.User;

public class PermissionFactory {
    public static Permission getAddToCartPermission(User user, FoodItem foodItem){
        return new AddToCartPermission(user, foodItem);
    }
}
