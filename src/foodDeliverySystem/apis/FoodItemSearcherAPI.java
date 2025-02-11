package foodDeliverySystem.apis;

import foodDeliverySystem.data.CuisineType;
import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.data.MealType;
import foodDeliverySystem.data.StarRating;
import foodDeliverySystem.filters.CuisineTypeFilter;
import foodDeliverySystem.filters.FoodItemFilter;
import foodDeliverySystem.filters.MealTypeFilter;
import foodDeliverySystem.filters.StarRatingFilter;
import foodDeliverySystem.searchers.FoodItemSearcher;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcherAPI {
    // Follow OCP: search should not change if new type comes in
    // Filter F1, F2, F3
    // -- foodItem --> F - True/False
    public List<FoodItem> searchFoodItems(String foodItemName, MealType mealType, List<CuisineType> cuisines, StarRating rating){
        List<FoodItemFilter> filters = new ArrayList<>();
        if(mealType != null){
            filters.add(new MealTypeFilter(mealType));
        }
        if(cuisines != null){
            filters.add(new CuisineTypeFilter(cuisines));
        }
        if(rating != null){
            filters.add(new StarRatingFilter(rating));
        }
        FoodItemSearcher foodItemSearch = new FoodItemSearcher();
        return foodItemSearch.search(foodItemName, filters);
    }
}
