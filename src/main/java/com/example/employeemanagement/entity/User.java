package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String role;

    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@(gmail\\.com|yahoo\\.in|outlook\\.com)$",
            message = "invalid email format"
    )
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private LocalDate joiningDate;
}
