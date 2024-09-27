package com.akasa_air_Vishnu_Nair.akasa_air_backend.repository;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByUserEmail(String userEmail); // Custom query method to find cart by user email
}
