// File: LoginResponse.java
package com.akasa_air_Vishnu_Nair.akasa_air_backend.dto;

public class LoginResponse {
    private String email;
    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginResponse(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Constructors, getters, and setters
}