package com.example.employeems.model.dto;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.model.enums.Gender;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

/**
 * A DTO for the {@link EmployeeEntity} entity
 */
@Data
public class EmployeeDto  {

    @Null
    private final Long id;

    @NotNull(message = "First name can't be null")
    @NotBlank(message = "First name must contain at least one character")
    private final String firstName;

    @NotBlank(message = "Last name name must contain at least one character")
    private final String lastName;

    @NotNull
    private final Gender gender;

    @NotNull(message = "Birth date can't be null")
    private final LocalDate birthDate;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private final String email;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private final String phoneNumber;

    @NotNull(message = "Address can't be null")
    private final String address;

    @NotNull(message = "Salary can't be null")
    private final Double salary;

    private final Long positionId;

}