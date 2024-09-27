package com.akasa_air_Vishnu_Nair.akasa_air_backend.repository;



import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email); // Custom query method to find user by email
}
