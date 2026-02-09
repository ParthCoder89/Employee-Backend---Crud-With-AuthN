package com.example.EmployeeManagement.with.AuthN.Auth.AuthController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/secure")
    public String secure(){
        return "Jwt Authenticated API";
    }
}
