package com.akasa_air_Vishnu_Nair.akasa_air_backend.service;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Item;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Add a new item to the inventory
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    // Update an existing item
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    // Delete an item by ID
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }

    // Get an item by its ID
    public Item getItemById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    // New method to update stock of an item directly
    public Item updateStock(String itemId, int quantityPurchased) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        int newStock = item.getStock() - quantityPurchased;

        if (newStock < 0) {
            throw new RuntimeException("Insufficient stock for item: " + item.getName());
        }

        item.setStock(newStock);
        return itemRepository.save(item); // Save the updated stock
    }

    // New method to check if stock is sufficient for a given item and quantity
    public boolean isStockSufficient(String itemId, int requestedQuantity) {
        Item item = itemRepository.findById(itemId).orElse(null);
        if (item == null) {
            throw new RuntimeException("Item not found");
        }
        return item.getStock() >= requestedQuantity;
    }
}
