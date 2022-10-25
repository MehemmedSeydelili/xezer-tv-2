package com.example.employeems.model.dto;

import com.example.employeems.model.view.DepartmentView;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PositionDto {

    @NotBlank(message = "Position name can't be empty")
    private String name;

    @NotNull(message = "Department must not be null")
    private DepartmentView department;

}
