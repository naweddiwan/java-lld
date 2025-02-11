package foodDeliverySystem.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Restaurant {
    private final int id;
    private final String name;
    private final String description;
    private final BusinessHours businessHours;
    private final List<CuisineType> cuisineTypes;
    private final StarRating starRating;
    private final MealType mealType;
    private final Menu menu;
    private final Address address;

    public Restaurant(int id, String name, String description, BusinessHours businessHours, List<CuisineType> cuisineTypes, StarRating starRating, MealType mealType, Menu menu, Address address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.businessHours = businessHours;
        this.cuisineTypes = cuisineTypes;
        this.starRating = starRating;
        this.mealType = mealType;
        this.menu = menu;
        this.address = address;
    }
}
