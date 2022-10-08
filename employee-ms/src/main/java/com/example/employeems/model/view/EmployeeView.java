package com.example.employeems.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeView {
    private  Long id;
    private  String firstName;
    private  String lastName;
    private  LocalDate birthDate;
    private  String mobilePhone;
    private  String address;
    private  Double salary;

}