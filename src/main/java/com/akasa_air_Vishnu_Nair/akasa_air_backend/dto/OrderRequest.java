package com.akasa_air_Vishnu_Nair.akasa_air_backend.dto;

import java.util.List;

public class OrderRequest {

    private String userEmail; // Changed from userId to userEmail
    private List<String> itemIds; // List of item IDs in the order
    private double totalAmount;

    // Constructors
    public OrderRequest() {}

    public OrderRequest(String userEmail, List<String> itemIds, double totalAmount) {
        this.userEmail = userEmail; // Updated constructor
        this.itemIds = itemIds;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getUserEmail() {
        return userEmail; // Updated getter
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail; // Updated setter
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
