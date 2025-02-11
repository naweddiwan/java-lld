package foodDeliverySystem.permissions;

import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.data.Restaurant;
import foodDeliverySystem.data.User;
import foodDeliverySystem.managers.DeliveryManager;
import foodDeliverySystem.searchers.RestaurantSearcher;

public class AddToCartPermission implements  Permission{
    private final User user;
    private final FoodItem foodItem;
    private final DeliveryManager deliveryManager = new DeliveryManager();

    public AddToCartPermission(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
    }

    @Override
    public boolean isPermitted() {
        if(!foodItem.isAvailable()){
            return false;
        }
        Restaurant restaurant =  new RestaurantSearcher().searchById(foodItem.getId());

        boolean isDeliveryPossible = deliveryManager.isDeliveryPossible(restaurant.getAddress(), user.getAddress());
        if(!isDeliveryPossible){
            return false;
        }

        return true;
    }
}
