package com.example.EmployeeManagement.with.AuthN.Auth.AuthService;

import com.example.EmployeeManagement.with.AuthN.Auth.AuthEntity.AUser;

public interface AUserService {
    AUser saveUser(AUser aUser);

    AUser getUserByName(String aUserName);
}
