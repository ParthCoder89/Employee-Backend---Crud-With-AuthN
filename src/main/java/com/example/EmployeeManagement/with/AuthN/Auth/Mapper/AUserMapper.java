package com.example.EmployeeManagement.with.AuthN.Auth.Mapper;

import com.example.EmployeeManagement.with.AuthN.Auth.AuthDto.AUserDto;
import com.example.EmployeeManagement.with.AuthN.Auth.AuthEntity.AUser;

public class AUserMapper{
    public static AUserDto EntityToDto(AUser aUser){
        return new AUserDto(
                aUser.getUserName(),
                aUser.getPassword(),
                aUser.getEmail()
        );
    }

    public static AUser DtoToEntity(AUserDto aUserDto){
        AUser aUser = new AUser();
        aUser.setUserName(aUserDto.getUserName());
        aUser.setEmail(aUserDto.getEmail());
        aUser.setPassword(aUserDto.getPassword());
        return aUser;
    }
}
