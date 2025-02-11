package foodDeliverySystem.data;

import lombok.Getter;

@Getter
public class CartItem {
    private final FoodItem foodItem;
    private final int quantity;

    public CartItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }
}
