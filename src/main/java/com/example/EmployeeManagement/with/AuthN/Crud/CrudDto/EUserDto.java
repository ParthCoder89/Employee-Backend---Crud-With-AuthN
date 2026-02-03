package com.example.EmployeeManagement.with.AuthN.Crud.CrudDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
