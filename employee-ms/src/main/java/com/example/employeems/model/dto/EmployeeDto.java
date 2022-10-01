package com.example.employeems.model.dto;

import com.example.employeems.dao.entity.EmployeeEntity;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link EmployeeEntity} entity
 */
@Data
public class EmployeeDto implements Serializable {

    @NotNull(message = "First name can't be null")
    @NotEmpty(message = "First name can't be empty")
    @NotBlank
    private final String firstName;

    @NotNull(message = "Last name can't be null")
    @NotEmpty(message = "Last name can't be empty")
    @NotBlank
    private final String lastName;

    private final LocalDate birthDate;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private final String email;
    private final String address;
    private final Double salary;
    private final Long positionId;
}