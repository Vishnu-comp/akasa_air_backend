package com.akasa_air_Vishnu_Nair.akasa_air_backend.model;

import org.springframework.data.annotation.Id;

public class CartItem {
    private String itemId; // Reference to the Item
    private int quantity; // Quantity of this item

    public CartItem(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
