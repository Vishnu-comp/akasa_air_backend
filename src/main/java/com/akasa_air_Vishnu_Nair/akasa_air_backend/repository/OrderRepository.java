package com.akasa_air_Vishnu_Nair.akasa_air_backend.repository;



import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId); // Custom query method to find orders by user ID
}

