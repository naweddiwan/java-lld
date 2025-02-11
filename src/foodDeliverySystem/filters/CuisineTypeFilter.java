package foodDeliverySystem.filters;

import foodDeliverySystem.data.CuisineType;
import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.data.Restaurant;

import java.util.List;

public class CuisineTypeFilter implements FoodItemFilter , RestaurantFilter{
    private List<CuisineType> cuisineTypes;

    public CuisineTypeFilter(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisineTypes.contains(foodItem.getCuisineType());
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        // Get all restaurants having atleast one common cuisine.
        for(CuisineType cuisineType: cuisineTypes){
            if(restaurant.getCuisineTypes().contains(cuisineType)){
                return true;
            }
        }
        return false;
    }
}
