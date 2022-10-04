package com.example.employeems.model.view;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EmployeeView implements Serializable {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String mobilePhone;
    private final String address;
    private final Double salary;

}