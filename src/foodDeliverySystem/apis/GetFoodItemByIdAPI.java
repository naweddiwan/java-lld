package foodDeliverySystem.apis;

import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.searchers.FoodItemSearcher;

public class GetFoodItemByIdAPI {

    public FoodItem getFoodItemById(int id){
        // TODO: validation
        return new FoodItemSearcher().searchById(id);
    }
}
