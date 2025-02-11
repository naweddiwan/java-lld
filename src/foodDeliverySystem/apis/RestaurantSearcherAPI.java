package foodDeliverySystem.apis;

import foodDeliverySystem.data.CuisineType;
import foodDeliverySystem.data.MealType;
import foodDeliverySystem.data.Restaurant;
import foodDeliverySystem.data.StarRating;
import foodDeliverySystem.filters.CuisineTypeFilter;
import foodDeliverySystem.filters.FoodItemFilter;
import foodDeliverySystem.filters.MealTypeFilter;
import foodDeliverySystem.filters.StarRatingFilter;
import foodDeliverySystem.searchers.RestaurantSearcher;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcherAPI {
    public List<Restaurant> searchRestaurant(String restaurantName, MealType mealType, List<CuisineType> cuisineTypes, StarRating starRating) {
        // Validating request Parameters
        List<FoodItemFilter> filters = new ArrayList<>();
        if(mealType != null){
            filters.add(new MealTypeFilter(mealType));
        }
        if(cuisineTypes != null){
            filters.add(new CuisineTypeFilter(cuisineTypes));
        }
        if(starRating != null){
            filters.add(new StarRatingFilter(starRating));
        }
        return new RestaurantSearcher(restaurantName, filters).search();
    }
}
