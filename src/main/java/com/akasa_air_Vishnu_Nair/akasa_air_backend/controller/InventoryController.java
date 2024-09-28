package com.akasa_air_Vishnu_Nair.akasa_air_backend.controller;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.dto.StockUpdateRequest;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Item;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private ItemService itemService;

    // Get all items in the inventory
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    // Add a new item to the inventory
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(itemService.addItem(item));
    }

    // Update item details in the inventory
    @PutMapping("/update")
    public ResponseEntity<Item> updateItem(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(itemService.updateItem(item));
    }

    // Delete an item from the inventory
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }

    // Get item details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // New endpoint to update the stock after a successful checkout
    @PutMapping("/update-stock")
    public ResponseEntity<Item> updateStock(@Valid @RequestBody StockUpdateRequest stockUpdateRequest) {
        Item item = itemService.getItemById(stockUpdateRequest.getItemId());
        if (item != null) {
            // Ensure stock is decreased
            int newStock = item.getStock() - stockUpdateRequest.getQuantityPurchased();
            if (newStock < 0) {
                return ResponseEntity.badRequest().body(null); // Return error if stock is negative
            }
            item.setStock(newStock);
            itemService.updateItem(item);
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // New endpoint to check stock before checkout
    @GetMapping("/check-stock/{id}/{quantity}")
    public ResponseEntity<String> checkStock(@PathVariable String id, @PathVariable int quantity) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            if (item.getStock() >= quantity) {
                return ResponseEntity.ok("Stock is sufficient");
            } else {
                return ResponseEntity.badRequest().body("Stock is insufficient. Available stock: " + item.getStock());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
