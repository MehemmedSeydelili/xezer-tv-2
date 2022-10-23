package com.example.employeems.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DepartmentDto {

    @NotBlank(message = "Department must not be null and must contain at least one non-whitespace character")
    private String name;

}
