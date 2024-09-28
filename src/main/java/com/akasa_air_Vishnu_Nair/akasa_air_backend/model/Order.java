package com.akasa_air_Vishnu_Nair.akasa_air_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String userEmail;
    private List<String> itemIds;
    private double totalAmount;
    private Date orderDate;
    private String status;

    // Default constructor (required for Spring Data)
    public Order() {
    }

    // Parameterized constructor
    public Order(String id, String userEmail, List<String> itemIds, double totalAmount, Date orderDate, String status) {
        this.id = id;
        this.userEmail = userEmail;
        this.itemIds = itemIds;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters and Setters
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString() for better logging/debugging
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", itemIds=" + itemIds +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                '}';
    }
}
