package com.example.employeems.model.dto;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.model.enums.Gender;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * A DTO for the {@link EmployeeEntity} entity
 */
@Data
public class EmployeeDto  {

    @NotNull(message = "First name can't be null")
    @NotBlank(message = "")
    private final String firstName;

    @NotBlank
    private final String lastName;

    private final Gender gender;

    @NotNull(message = "Birth date can't be null")
    private final LocalDate birthDate;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private final String email;

    @NotNull(message = "Address can't be null")
    private final String address;

    @NotNull(message = "Salary can't be null")
    private final Double salary;

}