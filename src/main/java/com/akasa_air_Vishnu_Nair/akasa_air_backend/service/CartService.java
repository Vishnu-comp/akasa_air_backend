package com.akasa_air_Vishnu_Nair.akasa_air_backend.service;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Cart;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.CartItem; // Import CartItem
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Item; // Import Item
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.CartRepository;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.ItemRepository; // Import ItemRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository; // To fetch item details




    public Cart addToCart(String userEmail, String itemId, int quantity) {
        Cart cart = cartRepository.findByUserEmail(userEmail);

        // If cart does not exist, create a new one
        if (cart == null) {
            cart = new Cart();
            cart.setUserEmail(userEmail);
            cart.setItems(new ArrayList<>()); // Initialize items list
        }

        // Fetch the item from the repository using itemId
        Item item = itemRepository.findById(itemId).orElse(null); // Get the item details

        // Check if the item exists
        if (item != null) {
            // Check if the item is already in the cart
            boolean itemExists = false;
            for (CartItem cartItem : cart.getItems()) {
                if (cartItem.getItemId().equals(itemId)) {
                    cartItem.setQuantity(cartItem.getQuantity() + quantity); // Update quantity if item exists
                    itemExists = true;
                    break;
                }
            }

            // If the item does not exist in the cart, create a new CartItem
            if (!itemExists) {
                CartItem cartItem = new CartItem(itemId, quantity);
                cart.getItems().add(cartItem); // Add the new CartItem to the cart's items
            }
        } else {
            System.out.println("Item not found for itemId: " + itemId);
        }

        // Log the cart state before saving
        System.out.println("Cart before saving: " + cart);

        // Save the cart and return it
        Cart savedCart = cartRepository.save(cart);

        // Log the saved cart
        System.out.println("Saved Cart: " + savedCart);

        return savedCart; // Return the saved cart
    }


    // Method to retrieve the cart by user's email
    public Cart getCartByUserEmail(String email) {
        return cartRepository.findByUserEmail(email);
    }

    // Method to update the cart (if necessary)
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Method to remove an item from the cart
    public void removeFromCart(String email, String itemId) {
        Cart cart = cartRepository.findByUserEmail(email);
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getItemId().equals(itemId)); // Assuming your CartItem class has a getItemId() method
            cartRepository.save(cart); // Save the updated cart
        } else {
            System.out.println("Cart not found for email: " + email);
        }
    }
}
