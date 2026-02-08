package com.example.EmployeeManagement.with.AuthN.Auth.AuthSecurity;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AUserJwtUtil {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                .signWith(key)
                .compact();
    }

    public String extractUserName(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)   // ✅ correct method
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);   // ✅ if parse successful -> valid token
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("JWT Expired!");
        } catch (MalformedJwtException e) {
            System.out.println("JWT Malformed!");
        } catch (SignatureException e) {
            System.out.println("JWT Signature Invalid!");
        } catch (IllegalArgumentException e) {
            System.out.println("JWT Token is null or empty!");
        }
        return false;
    }
}
