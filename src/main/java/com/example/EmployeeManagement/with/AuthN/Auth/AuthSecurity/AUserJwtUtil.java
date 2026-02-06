package com.example.EmployeeManagement.with.AuthN.Auth.AuthSecurity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
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

    public String extractUserName(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }
}
