package foodDeliverySystem.filters;

import foodDeliverySystem.data.FoodItem;
import foodDeliverySystem.data.Restaurant;
import foodDeliverySystem.data.StarRating;

public class StarRatingFilter implements  FoodItemFilter, RestaurantFilter{
    private final StarRating starRating;

    public StarRatingFilter(StarRating starRating) {
        this.starRating = starRating;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal() > this.starRating.getVal();
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getStarRating().getVal() >= starRating.getVal();
    }
}
