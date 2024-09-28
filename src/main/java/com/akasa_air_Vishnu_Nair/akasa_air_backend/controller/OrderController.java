// File: OrderController.java
package com.akasa_air_Vishnu_Nair.akasa_air_backend.controller;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Order;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@Valid @RequestBody Order order) {
        return ResponseEntity.ok(orderService.checkout(order));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<Order>> getOrdersByUserEmail(@PathVariable String email) {
        return ResponseEntity.ok(orderService.getOrdersByUserEmail(email));
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable String id, @RequestParam String status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
    }
}