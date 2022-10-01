package com.example.employeems.model.view;

import com.example.employeems.dao.entity.ExperienceEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
public class EmployeeView implements Serializable {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String mobilePhone;
    private final String address;
    private final Double salary;
    private Set<ExperienceEntity> experiences;

}