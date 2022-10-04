package com.example.employeems.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class PositionDto implements Serializable {
    private long id;
    @NotEmpty(message = "Position name can't be empty")
    private String name;
    private long departmentId;
}
