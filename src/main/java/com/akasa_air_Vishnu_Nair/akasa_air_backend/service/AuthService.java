// File: AuthService.java
package com.akasa_air_Vishnu_Nair.akasa_air_backend.service;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.dto.UserDTO;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.User;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFullName(userDTO.getFullName());
        return userRepository.save(user);
    }
}