package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.ApiResponse;
import com.example.employeemanagement.dto.CreateUserRequestDto;
import com.example.employeemanagement.dto.CreateUserRespDto;
import com.example.employeemanagement.entity.User;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.mapper.UserServiceMapper;
import com.example.employeemanagement.repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    UserServiceMapper userServiceMapper;

    public ResponseEntity<ApiResponse<User>> createUser(CreateUserRequestDto request) {
        User user=userServiceMapper.mapToEntity(request);
        User createdUser = userRepository.save(user);
        return userServiceMapper.mapToApiResponse(createdUser, "User created successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<ApiResponse<User>> getUserdetail(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id: "+id));
        return userServiceMapper.mapToApiResponse(user, "User retrieved successfully", HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse<User>> deleteUser(Long id){
        userRepository.delete(userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id: "+id)));
        return userServiceMapper.mapToApiResponse(null, "User deleted successfully", HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<ApiResponse<User>> updateUser(long id,CreateUserRequestDto request) {
        userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id: "+ id));
        User user=userServiceMapper.mapToEntity(request);
        User updatedUser = userRepository.save(user);
        return userServiceMapper.mapToApiResponse(updatedUser, "User updated successfully", HttpStatus.OK);
    }
}
