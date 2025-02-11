package foodDeliverySystem.filters;

import foodDeliverySystem.data.FoodItem;

public interface FoodItemFilter {
    boolean filter(FoodItem foodItem);
}
