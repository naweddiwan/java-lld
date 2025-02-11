package foodDeliverySystem.data;

import lombok.Getter;

import java.util.List;

@Getter
public class Menu {
    private final List<FoodItem> foodItems;

    public Menu(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
