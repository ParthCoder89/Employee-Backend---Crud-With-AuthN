package com.example.EmployeeManagement.with.AuthN.Crud.CrudMapper;

import com.example.EmployeeManagement.with.AuthN.Crud.CrudDto.EUserDto;
import com.example.EmployeeManagement.with.AuthN.Crud.CrudEntity.EUser;

public class EUserMapper {
    public static EUserDto entityToDto(EUser eUser){
        return new EUserDto(
                eUser.getId(),
                eUser.getFirstName(),
                eUser.getLastName(),
                eUser.getEmail()
        );
    }

    public static EUser dtoToEntity(EUserDto eUserDto){
        return new EUser(
                eUserDto.getId(),
                eUserDto.getFirstName(),
                eUserDto.getLastName(),
                eUserDto.getEmail()
        );
    }
}
