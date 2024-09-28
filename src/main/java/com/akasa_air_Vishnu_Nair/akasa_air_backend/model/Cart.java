package com.akasa_air_Vishnu_Nair.akasa_air_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "carts")
public class Cart {

    @Id
    private String id;
    private String userEmail;
    private List<CartItem> items;

    public Cart() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Cart(String id, String userEmail, List<CartItem> items) {
        this.id = id;
        this.userEmail = userEmail;
        this.items = items;
    }
}
