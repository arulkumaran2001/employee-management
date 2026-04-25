package com.example.employeemanagement.controller;

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
    public ResponseEntity<CreateUserRespDto> createUser(@RequestBody CreateUserRequestDto request) {
        // Logic to create a user
        CreateUserRespDto response = userService.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserdetail(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String message = userService.deleteUser(id);
         return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id,@RequestBody CreateUserRequestDto requestDto){
        String message = userService.updateUser(id,requestDto);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
