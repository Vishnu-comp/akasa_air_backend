package com.akasa_air_Vishnu_Nair.akasa_air_backend.dto;

public class LoginResponse {
    private String email; // Changed from userId to email
    private String token;

    // Constructors
    public LoginResponse() {}

    public LoginResponse(String email, String token) {
        this.email = email; // Use email instead of userId
        this.token = token;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
