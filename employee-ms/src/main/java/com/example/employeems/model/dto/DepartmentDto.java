package com.example.employeems.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class DepartmentDto implements Serializable {
    private long id;
    @NotEmpty(message = "First name can't be empty")
    private String name;





}
