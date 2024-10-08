package com.akasa_air_Vishnu_Nair.akasa_air_backend.controller;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Cart;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.CartItem;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{userEmail}")
    public ResponseEntity<Cart> addToCart(@PathVariable String userEmail, @Valid @RequestBody CartItem cartItem) {
        Cart updatedCart = cartService.addToCart(userEmail, cartItem.getItemId(), cartItem.getQuantity());
        return ResponseEntity.ok(updatedCart);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<Cart> getCartByEmail(@PathVariable String email) {
        Cart cart = cartService.getCartByUserEmail(email);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/update")
    public ResponseEntity<Cart> updateCart(@Valid @RequestBody Cart cart) {
        Cart updatedCart = cartService.updateCart(cart);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/remove/{email}/{itemId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable String email, @PathVariable String itemId) {
        cartService.removeFromCart(email, itemId);
        return ResponseEntity.ok().build();
    }
}