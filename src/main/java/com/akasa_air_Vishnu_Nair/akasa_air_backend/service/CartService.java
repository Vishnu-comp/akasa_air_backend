package com.akasa_air_Vishnu_Nair.akasa_air_backend.service;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Cart;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.CartItem;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Item;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.CartRepository;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Cart addToCart(String userEmail, String itemId, int quantity) {
        Cart cart = cartRepository.findByUserEmail(userEmail);

        if (cart == null) {
            cart = new Cart();
            cart.setUserEmail(userEmail);
            cart.setItems(new ArrayList<>());
        }

        Item item = itemRepository.findById(itemId).orElse(null);

        if (item != null) {
            boolean itemExists = false;
            for (CartItem cartItem : cart.getItems()) {
                if (cartItem.getItemId().equals(itemId)) {
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                    itemExists = true;
                    break;
                }
            }

            if (!itemExists) {
                // Fix: Change the order of parameters to match the CartItem constructor
                CartItem cartItem = new CartItem(itemId, quantity, item.getName(), item.getPrice());
                cart.getItems().add(cartItem);
            }
        } else {
            throw new RuntimeException("Item not found for itemId: " + itemId);
        }

        return cartRepository.save(cart);
    }

    public Cart getCartByUserEmail(String email) {
        Cart cart = cartRepository.findByUserEmail(email);
        if (cart != null) {
            List<CartItem> updatedItems = new ArrayList<>();
            for (CartItem cartItem : cart.getItems()) {
                Item item = itemRepository.findById(cartItem.getItemId()).orElse(null);
                if (item != null) {
                    cartItem.setName(item.getName());
                    cartItem.setPrice(item.getPrice());
                }
                updatedItems.add(cartItem);
            }
            cart.setItems(updatedItems);
        }
        return cart;
    }

    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void removeFromCart(String email, String itemId) {
        Cart cart = cartRepository.findByUserEmail(email);
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getItemId().equals(itemId));
            cartRepository.save(cart);
        } else {
            throw new RuntimeException("Cart not found for email: " + email);
        }
    }
}