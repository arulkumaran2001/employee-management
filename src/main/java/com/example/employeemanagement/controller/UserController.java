package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.ApiResponse;
import com.example.employeemanagement.dto.CreateUserRequestDto;
import com.example.employeemanagement.dto.CreateUserRespDto;
import com.example.employeemanagement.entity.User;
import com.example.employeemanagement.repository.UserRepository;
import com.example.employeemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;
    
    @Autowired
    UserRepository userRepository;


    @GetMapping("users")
    public List<User> getAllUsers() {
        // Logic to get all users
        return userRepository.findAll();
    }

    @PostMapping("user")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody CreateUserRequestDto request) {
        return userService.createUser(request);
    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable Long id) {
        return userService.getUserdetail(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<User>> deleteUser(@PathVariable Long id) {
         return userService.deleteUser(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable long id,@RequestBody CreateUserRequestDto request){
        return userService.updateUser(id,request);
    }
}
