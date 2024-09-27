package com.akasa_air_Vishnu_Nair.akasa_air_backend.controller;

import com.akasa_air_Vishnu_Nair.akasa_air_backend.dto.LoginRequest;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.dto.LoginResponse;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.dto.UserDTO;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.model.User;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.service.AuthService;
import com.akasa_air_Vishnu_Nair.akasa_air_backend.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User user = authService.registerUser(userDTO);
        return ResponseEntity.ok(user); // Return ResponseEntity containing the User object
    }

    @PostMapping("/login")
    // public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
    //     authenticationManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

    //     final UserDetails userDetails = authService.loadUserByUsername(loginRequest.getEmail());
    //     final String jwt = jwtUtil.generateToken(userDetails.getUsername());

    //     // Get userId from userDetails or load user from the database
    //     User user = authService.getUserByEmail(loginRequest.getEmail());

    //     // Create a response object that includes userId and JWT
    //     LoginResponse loginResponse = new LoginResponse(user.getId(), jwt);

    //     return ResponseEntity.ok(loginResponse); // Return ResponseEntity containing userId and JWT token
    // }
public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

    final UserDetails userDetails = authService.loadUserByUsername(loginRequest.getEmail());
    final String jwt = jwtUtil.generateToken(userDetails.getUsername()); // This now returns the email

    // Get user from user details or load user from the database
    User user = authService.getUserByEmail(loginRequest.getEmail());

    // Create a response object that includes userId and JWT
    LoginResponse loginResponse = new LoginResponse(user.getEmail(), jwt);

    return ResponseEntity.ok(loginResponse); // Return ResponseEntity containing userId and JWT token
}

}
