package com.example.employeems.mapper;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;

public class EmployeeMapper {
    public  EmployeeEntity dtoToEntity(EmployeeDto employeeDto){
        return EmployeeEntity.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .birthDate(employeeDto.getBirthDate())
                .email(employeeDto.getEmail())
                .address(employeeDto.getAddress())
                .salary(employeeDto.getSalary())
                .build();
    }

    public EmployeeView entityToView(EmployeeEntity employee){
        return EmployeeView.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthDate(employee.getBirthDate())
                .mobilePhone(employee.getPhoneNumber())
                .address(employee.getAddress())
                .salary(employee.getSalary())
                .build();

    }
}
