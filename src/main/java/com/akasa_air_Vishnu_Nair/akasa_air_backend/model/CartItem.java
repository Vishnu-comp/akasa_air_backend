package com.akasa_air_Vishnu_Nair.akasa_air_backend.model;

public class CartItem {
    private String itemId;
    private int quantity;
    private String userEmail; // Add this field

    public CartItem(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.userEmail = userEmail;
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

    public String getUserEmail() { // Add getter for userEmail
        return userEmail;
    }

    public void setUserEmail(String userEmail) { // Add setter for userEmail
        this.userEmail = userEmail;
    }
}
