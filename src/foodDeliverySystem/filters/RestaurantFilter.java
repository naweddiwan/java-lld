package foodDeliverySystem.filters;

import foodDeliverySystem.data.Restaurant;

public interface RestaurantFilter {
    boolean filter(Restaurant restaurant);
}
