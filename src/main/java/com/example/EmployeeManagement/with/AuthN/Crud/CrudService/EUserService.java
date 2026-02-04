package com.example.EmployeeManagement.with.AuthN.Crud.CrudService;

import com.example.EmployeeManagement.with.AuthN.Crud.CrudDto.EUserDto;
import com.example.EmployeeManagement.with.AuthN.Crud.CrudEntity.EUser;

import java.util.List;

public interface EUserService{
    EUserDto createUser(EUserDto eUserDto);

    EUserDto getUser(Long id);

    List<EUserDto> getAllUsers();

    EUserDto updateUser(EUserDto eUserDto, Long id);

    void deleteUser(Long id);
}
