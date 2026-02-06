package com.example.EmployeeManagement.with.AuthN.Auth.AuthService;

import com.example.EmployeeManagement.with.AuthN.Auth.AuthEntity.AUser;
import com.example.EmployeeManagement.with.AuthN.Auth.AuthRepository.AUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AUserServiceImpl implements AUserService{

    private final AUserRepository aUserRepository;

    @Override
    public AUser saveUser(AUser aUser) {
        return aUserRepository.save(aUser);
    }

    @Override
    public AUser getUserByName(String aUserName) {
        return aUserRepository.findByUserName(aUserName).orElse(null);
    }
}
