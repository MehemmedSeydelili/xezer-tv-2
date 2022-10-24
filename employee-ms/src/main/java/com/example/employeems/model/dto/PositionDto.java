package com.example.employeems.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PositionDto{

    @NotEmpty(message = "Position name can't be empty")
    private String name;

}
