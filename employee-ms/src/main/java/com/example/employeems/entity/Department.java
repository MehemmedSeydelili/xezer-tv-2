package com.example.employeems.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department_name")
    private String departmentname;


    public void setdepartmentname(Object getdepartmentname) {
    }
}
