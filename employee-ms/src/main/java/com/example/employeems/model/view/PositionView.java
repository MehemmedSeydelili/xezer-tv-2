package com.example.employeems.model.view;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionView {

    private Long id;
    private String name;
    private DepartmentView department;
}
