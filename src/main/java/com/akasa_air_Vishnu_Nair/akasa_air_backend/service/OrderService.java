package com.akasa_air_Vishnu_Nair.akasa_air_backend.service;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Item;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Order;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.ItemRepository;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository; // Inject your repository

    @Autowired
    private ItemRepository itemRepository; // Inject ItemRepository for fetching item details

    public Order createOrder(Order order) {
        return orderRepository.save(order); // Save the order in the database
    }

    // Modify the logic to fetch item details (including imageUrl) for each order item
    public List<Order> getOrdersByUserEmail(String email) {
        List<Order> orders = orderRepository.findByUserEmail(email);
        for (Order order : orders) {
            List<String> updatedItemIds = new ArrayList<>();
            for (String itemId : order.getItemIds()) {
                Item item = itemRepository.findById(itemId).orElse(null);
                if (item != null) {
                    // Replace itemId with the necessary item details like imageUrl
                    updatedItemIds.add(item.getId() + "|" + item.getName() + "|" + item.getPrice() + "|" + item.getImageUrl());
                } else {
                    updatedItemIds.add(itemId); // Keep the ID if item not found
                }
            }
            order.setItemIds(updatedItemIds); // Update the order with item details (including imageUrl)
        }
        return orders;
    }

    public Order updateOrderStatus(String id, String status) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
