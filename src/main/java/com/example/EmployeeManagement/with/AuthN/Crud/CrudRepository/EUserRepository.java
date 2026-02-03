package com.example.EmployeeManagement.with.AuthN.Crud.CrudRepository;

import com.example.EmployeeManagement.with.AuthN.Crud.CrudEntity.EUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EUserRepository extends JpaRepository<EUser, Long> {
}
