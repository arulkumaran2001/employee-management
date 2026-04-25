package com.example.employeemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CreateUserRequestDto {
    @NotBlank(message = "Name is required")
    private String username;

    @NotBlank(message = "role is required")
    private String role;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "salary is required")
    private Double salary;


    private LocalDate joiningDate;
}
