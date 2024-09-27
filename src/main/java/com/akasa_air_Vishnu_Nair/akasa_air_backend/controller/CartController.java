package com.akasa_air_Vishnu_Nair.akasa_air_backend.controller;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Cart;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Add items to cart
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        try {
            Cart updatedCart = cartService.addToCart(cart);
            return ResponseEntity.ok(updatedCart);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Return bad request for invalid input
        }
    }

    // Retrieve cart by user email
    @GetMapping("/user/{email}")
    public ResponseEntity<Cart> getCartByEmail(@PathVariable String email) {
        Cart cart = cartService.getCartByUserEmail(email);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }
}
