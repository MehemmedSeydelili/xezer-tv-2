package com.example.employeems.model.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class ExperienceDto {

    @NotBlank(message = "Workplace must not be null and must contain at least one non-whitespace character")
    private String workplace;

    @NotBlank(message = "Position must not be null and must contain at least one non-whitespace character")
    private String position;

    @NotNull(message = "Start date must not be null")
    private LocalDate startDate;

    private LocalDate endDate;


}
