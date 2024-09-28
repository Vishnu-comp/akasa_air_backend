package com.akasa_air_Vishnu_Nair.akasa_air_backend.service;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Order;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository; // Inject your repository

    public Order createOrder(Order order) {
        return orderRepository.save(order); // Save the order in the database
    }

    public List<Order> getOrdersByUserEmail(String email) {
        return orderRepository.findByUserEmail(email); // Implement this method in your repository
    }

    public Order updateOrderStatus(String id, String status) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
