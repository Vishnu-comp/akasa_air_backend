package com.akasa_air_Vishnu_Nair.akasa_air_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String name;
    private String category;
    private double price;
    private int stock;
    private int quantity; // New quantity field

    // Constructor
    public Item(String id, String name, String category, double price, int stock, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity; // Initialize quantity
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity; // Getter for quantity
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity; // Setter for quantity
    }
}
