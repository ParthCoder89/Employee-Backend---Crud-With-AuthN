package com.example.EmployeeManagement.with.AuthN.Crud.CrudController;

import com.example.EmployeeManagement.with.AuthN.Crud.CrudDto.EUserDto;
import com.example.EmployeeManagement.with.AuthN.Crud.CrudService.EUserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeecrud")
@RequiredArgsConstructor
@Getter
@Setter
public class EUserController {
    private final EUserService eUserService;

    @PostMapping
    public ResponseEntity<EUserDto> createUser(@RequestBody EUserDto eUserDto) {
        EUserDto employee = eUserService.createUser(eUserDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EUserDto> getUserById(@PathVariable("id") Long id){
        EUserDto employee = eUserService.getUser(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<EUserDto>> getAllUser(){
        List<EUserDto> employees = eUserService.getAllUsers();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EUserDto> updateUser(@RequestBody EUserDto eUserDto, @PathVariable("id") Long id){
        EUserDto employee = eUserService.updateUser(eUserDto, id);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        eUserService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }
}
