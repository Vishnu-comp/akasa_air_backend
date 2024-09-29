// File: AuthController.java
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO) {
        User user = authService.registerUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(userDetails.getUsername());

        LoginResponse loginResponse = new LoginResponse(userDetails.getUsername(), jwt);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean emailExists = authService.isEmailAlreadyRegistered(email);
        return ResponseEntity.ok(emailExists);
    }
}
