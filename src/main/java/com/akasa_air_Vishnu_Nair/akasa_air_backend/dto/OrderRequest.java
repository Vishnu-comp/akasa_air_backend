package com.akasa_air_Vishnu_Nair.akasa_air_backend.dto;

import java.util.List;

public class OrderRequest {

    private String userId;
    private List<String> itemIds; // List of item IDs in the order
    private double totalAmount;

    // Constructors
    public OrderRequest() {}

    public OrderRequest(String userId, List<String> itemIds, double totalAmount) {
        this.userId = userId;
        this.itemIds = itemIds;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

