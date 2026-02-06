package com.example.EmployeeManagement.with.AuthN.Auth.AuthDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AUserDto {
    private String userName;
    private String password;
    private String email;
}
