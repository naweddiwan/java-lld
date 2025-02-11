package foodDeliverySystem.searchers;

import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.filters.FoodItemFilter;

import java.util.List;
import java.util.stream.Collectors;

public class FoodItemSearcher {
    public List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters) {
        // Validations
        if(foodItemName == null || foodItemName.isEmpty() || filters == null) {
            throw new IllegalArgumentException("Missing Params");
        }
//        DataAccessResult dataAccessResult = DataAccessor.getFoodItemsWithName(foodItemName);
//        List<FoodItem> foodItems = DataAccessObjectConverter.convertToFoodItems(dataAccessResult);

//        return foodItems.stream()
//                .filter(fi -> filters.stream().allMatch(filter -> filter.filter(fi)))
//                .toList();
        return null;

    }

    public FoodItem searchById(int id) {
        return null;
    }
}
