package com.akasa_air_Vishnu_Nair.akasa_air_backend.model;

public class CartItem {
    private String itemId;
    private int quantity;
    private String name;
    private double price;
    private String imageUrl; // Add image URL field

    // Constructor with imageUrl
    public CartItem(String itemId, int quantity, String name, double price, String imageUrl) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
