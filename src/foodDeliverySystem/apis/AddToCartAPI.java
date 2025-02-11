package foodDeliverySystem.apis;

import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.data.User;
import foodDeliverySystem.managers.CartManager;
import foodDeliverySystem.managers.UserManager;
import foodDeliverySystem.searchers.FoodItemSearcher;

public class AddToCartAPI {
    private final UserManager userManager = new UserManager();
    private final FoodItemSearcher foodItemSearcher = new FoodItemSearcher();
    private final CartManager cartManager = new CartManager();

    public void addToCart(String userToken, int foodItemId) {
            if(userToken == null || userToken.isEmpty() || foodItemId < 0) {
                throw new IllegalArgumentException("Invalid Token");
            }
            User user = userManager.getUserByToken(userToken);


            FoodItem foodItem = foodItemSearcher.searchById(foodItemId);

            cartManager.addItemToCart(user, foodItem);

    }
}
