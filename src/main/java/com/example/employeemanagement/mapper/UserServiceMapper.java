package com.example.employeemanagement.mapper;

import com.example.employeemanagement.dto.ApiResponse;
import com.example.employeemanagement.dto.CreateUserRequestDto;
import com.example.employeemanagement.dto.CreateUserRespDto;
import com.example.employeemanagement.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class UserServiceMapper {

    public User mapToEntity(CreateUserRequestDto request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setRole(request.getRole());
        user.setEmail(request.getEmail());
        user.setSalary(request.getSalary());
        user.setJoiningDate(LocalDate.now());
        return user;
    }

    public CreateUserRespDto mapToDto(User savedUser) {
        CreateUserRespDto response=new CreateUserRespDto();
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setRole(savedUser.getRole());
        response.setEmail(savedUser.getEmail());
        response.setSalary(savedUser.getSalary());
        response.setJoiningDate(savedUser.getJoiningDate());
        return response;
    }
    public ResponseEntity<ApiResponse<User>> mapToApiResponse(User user, String message, HttpStatus status) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setData(user);
        response.setError(null);
        return new ResponseEntity<>(response, status);
//        return response;
    }
}
