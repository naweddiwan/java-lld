package foodDeliverySystem.managers;

import foodDeliverySystem.data.CartItem;
import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.data.User;
import foodDeliverySystem.permissions.Permission;
import foodDeliverySystem.permissions.PermissionFactory;

import java.util.List;

public class CartManager {
//    public List<CartItem> getUserCart(User user) {
//
//    }

    public  void addItemToCart(User user, FoodItem foodItem){
        Permission permission = PermissionFactory.getAddToCartPermission(user, foodItem);
        if(!permission.isPermitted()) {
            throw new RuntimeException("Permission Denied");
        }
    }

    public void deleteItemFromCart(User user, FoodItem foodItem) {

    }

    public void checkoutUserCart(User user) {

    }

   // private boolean isFoodItemFromSameRestaurant();
}
