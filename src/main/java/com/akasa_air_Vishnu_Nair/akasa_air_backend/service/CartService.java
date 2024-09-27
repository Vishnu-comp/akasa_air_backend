package com.akasa_air_Vishnu_Nair.akasa_air_backend.service;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Cart;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Retrieve cart by user email
    public Cart getCartByUserEmail(String email) {
        return cartRepository.findByUserEmail(email);
    }
}
