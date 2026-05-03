package com.example.employeemanagement.dto;

import com.example.employeemanagement.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateUserRespDto {
    private Long id;
    private String username;
    private Role role;
    private String email;
    private Double salary;
    private LocalDate joiningDate;
}
