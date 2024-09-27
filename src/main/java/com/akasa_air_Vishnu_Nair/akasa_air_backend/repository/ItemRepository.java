package com.akasa_air_Vishnu_Nair.akasa_air_backend.repository;


import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    // Custom query methods can be added here if needed
}

