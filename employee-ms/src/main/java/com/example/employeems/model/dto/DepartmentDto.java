package com.example.employeems.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private long id;
    private String departmentname;




    public Object getdepartmentname() {
    return departmentname;}
}
