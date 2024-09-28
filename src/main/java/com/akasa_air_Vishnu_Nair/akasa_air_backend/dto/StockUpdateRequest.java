// File: src/main/java/com/akasa_air_Vishnu_Nair/akasa_air_backend/dto/StockUpdateRequest.java

package com.akasa_air_Vishnu_Nair.akasa_air_backend.dto;

public class StockUpdateRequest {
    private String itemId;
    private int quantityPurchased;

    // Getters and Setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }
}
