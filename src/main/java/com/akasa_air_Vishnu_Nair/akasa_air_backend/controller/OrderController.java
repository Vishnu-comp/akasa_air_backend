package com.akasa_air_Vishnu_Nair.akasa_air_backend.controller;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.dto.OrderRequest;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Order;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@Valid @RequestBody OrderRequest orderRequest) {
        String userEmail = orderRequest.getUserEmail();
        List<String> itemIds = orderRequest.getItemIds();
        Double totalAmount = orderRequest.getTotalAmount();

        if (userEmail == null || itemIds == null || itemIds.isEmpty() || totalAmount == null) {
            return ResponseEntity.badRequest().body(null); // Return a bad request response
        }

        // Create a new order
        Order newOrder = new Order();
        newOrder.setUserEmail(userEmail);
        newOrder.setItemIds(itemIds);
        newOrder.setTotalAmount(totalAmount);
        newOrder.setOrderDate(new Date());  // Set the current date
        newOrder.setStatus("Order Successful");  // Set the status

        // Save the order
        Order savedOrder = orderService.createOrder(newOrder);

        return ResponseEntity.ok(savedOrder);  // Return the saved order
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<Order>> getOrdersByUserEmail(@PathVariable String email) {
        List<Order> orders = orderService.getOrdersByUserEmail(email);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable String id, @RequestParam String status) {
        Order updatedOrder = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(updatedOrder);
    }
}
