package com.akasa_air_Vishnu_Nair.akasa_air_backend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    // Remove JWT_TOKEN_VALIDITY since we won't use expiration
    // @Value("${jwt.expiration}")
    // private long JWT_TOKEN_VALIDITY;

    // Extract username (email) from token
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Remove extractExpiration method
    // public Date extractExpiration(String token) {
    //     return extractClaim(token, Claims::getExpiration);
    // }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    // Remove isTokenExpired method
    // private Boolean isTokenExpired(String token) {
    //     return extractExpiration(token).before(new Date());
    // }

    // Generate JWT token without expiration
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // Remove expiration setting
                // .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validate token without expiration check
    public Boolean validateToken(String token, String email) {
        final String extractedEmail = extractEmail(token);
        // Remove expiration validation
        // return (extractedEmail.equals(email) && !isTokenExpired(token));
        return extractedEmail.equals(email);
    }
}
