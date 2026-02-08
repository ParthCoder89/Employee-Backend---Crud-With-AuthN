package com.example.EmployeeManagement.with.AuthN.Auth.AuthRepository;

import com.example.EmployeeManagement.with.AuthN.Auth.AuthEntity.AUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AUserRepository extends JpaRepository<AUser, Long> {
    Optional<AUser> findByUserName(String userName);
}
