package com.example.EmployeeManagement.with.AuthN.Crud.CrudService;

import com.example.EmployeeManagement.with.AuthN.Crud.CrudDto.EUserDto;
import com.example.EmployeeManagement.with.AuthN.Crud.CrudEntity.EUser;
import com.example.EmployeeManagement.with.AuthN.Crud.CrudException.EUserException;
import com.example.EmployeeManagement.with.AuthN.Crud.CrudMapper.EUserMapper;
import com.example.EmployeeManagement.with.AuthN.Crud.CrudRepository.EUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EUserServiceImpl implements EUserService{

    public final EUserRepository eUserRepository;

    @Override
    public EUserDto createUser(EUserDto eUserDto) {
        EUser eUser = EUserMapper.dtoToEntity(eUserDto);
        EUser saveUser = eUserRepository.save(eUser);
        return EUserMapper.entityToDto(saveUser);
    }

    @Override
    public EUserDto getUser(Long id) {
        EUser eUser = eUserRepository.findById(id).orElseThrow(()->
                new EUserException("User Not Found At Given Id : " + id));
        return EUserMapper.entityToDto(eUser);
    }

    @Override
    public List<EUserDto> getAllUsers() {
        List<EUser> eUser = eUserRepository.findAll();
        return eUser.stream().map((employee)-> EUserMapper.entityToDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EUserDto updateUser(EUserDto eUserDto, Long id) {
        EUser eUser = eUserRepository.findById(id).orElseThrow(()->
                new EUserException("User not Found at given Id : " + id));

        eUser.setFirstName(eUserDto.getFirstName());
        eUser.setLastName(eUserDto.getLastName());
        eUser.setEmail(eUserDto.getEmail());

        EUser saveUser = eUserRepository.save(eUser);
        return EUserMapper.entityToDto(saveUser);
    }

    @Override
    public void deleteUser(Long id) {
        EUser eUser = eUserRepository.findById(id).orElseThrow(()->
                new EUserException("User not Found at given Id : " + id));
        eUserRepository.deleteById(id);
    }


}
