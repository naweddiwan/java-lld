package foodDeliverySystem.searchers;

import foodDeliverySystem.data.Restaurant;
import foodDeliverySystem.filters.FoodItemFilter;
import foodDeliverySystem.filters.RestaurantFilter;

import java.util.List;

public class RestaurantSearcher {

    public RestaurantSearcher(){

    }
    public RestaurantSearcher(List<FoodItemFilter> filters, String restaurantName) {

    }

    public List<Restaurant> search(String restaurantName, List<RestaurantFilter> filters) {

        return null;
    }

    public Restaurant searchById(int  id) {
        return null;
    }
}
