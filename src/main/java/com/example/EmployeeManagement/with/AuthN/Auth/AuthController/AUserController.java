package com.example.EmployeeManagement.with.AuthN.Auth.AuthController;

import com.example.EmployeeManagement.with.AuthN.Auth.AuthDto.AUserDto;
import com.example.EmployeeManagement.with.AuthN.Auth.AuthEntity.AUser;
import com.example.EmployeeManagement.with.AuthN.Auth.AuthException.AuserException;
import com.example.EmployeeManagement.with.AuthN.Auth.AuthSecurity.AUserJwtUtil;
import com.example.EmployeeManagement.with.AuthN.Auth.AuthService.AUserService;
import com.example.EmployeeManagement.with.AuthN.Auth.Mapper.AUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/**")
@RequiredArgsConstructor
public class AUserController {

    private final AUserService aUserService;
    private final PasswordEncoder passwordEncoder;
    private final AUserJwtUtil aUserJwtUtil;

    @PostMapping("/signup")
    public String saveUser(@RequestBody AUserDto aUserDto){
        AUser aUser = AUserMapper.DtoToEntity(aUserDto);
        aUser.setPassword(passwordEncoder.encode(aUser.getPassword()));
        aUserService.saveUser(aUser);
        return ("User Successfully signUp");
    }

    @PostMapping("/login")
    public String findUser(@RequestBody AUserDto aUserDto) {
        AUser aUser = aUserService.getUserByName(aUserDto.getUserName());
        if (aUser == null) throw new AuserException(("User Not Found"));
        if(!passwordEncoder.matches(aUserDto.getPassword(), aUser.getPassword())){
            throw new AuserException("Wrong Password");
        }
        return aUserJwtUtil.generateToken(aUser.getUserName());

    }

}
