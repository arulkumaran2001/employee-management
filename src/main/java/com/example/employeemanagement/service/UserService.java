package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.CreateUserRequestDto;
import com.example.employeemanagement.dto.CreateUserRespDto;
import com.example.employeemanagement.entity.User;
import com.example.employeemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public CreateUserRespDto createUser(CreateUserRequestDto request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setRole(request.getRole());
        user.setEmail(request.getEmail());
        user.setSalary(request.getSalary());
        user.setJoiningDate(LocalDate.now());

        User savedUser = userRepository.save(user);
        CreateUserRespDto response=new CreateUserRespDto();
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setRole(savedUser.getRole());
        response.setEmail(savedUser.getEmail());
        response.setSalary(savedUser.getSalary());
        response.setJoiningDate(savedUser.getJoiningDate());
        return response;
    }
    public User getUserdetail(Long Id){
        User user=userRepository.findById(Id).orElseThrow(()->new RuntimeException("User not found with id: "+Id));
        return user;
    }
    public String deleteUser(Long Id){
        userRepository.delete(userRepository.findById(Id).orElseThrow(()->new RuntimeException("User not found with id: "+Id)));
        return String.format("User with id %d deleted successfully",Id);
    }

    public String updateUser(long id,CreateUserRequestDto requestDto) {
        User updateUser=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with id: "+id));
        updateUser.setUsername(requestDto.getUsername());
        updateUser.setRole(requestDto.getRole());
        updateUser.setEmail(requestDto.getEmail());
        updateUser.setSalary(requestDto.getSalary());
        userRepository.save(updateUser);
        return String.format("User with id %d updated successfully",id);
    }
}
