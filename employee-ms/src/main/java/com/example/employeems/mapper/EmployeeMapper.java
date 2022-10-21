package com.example.employeems.mapper;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;

import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMapper {
    public static EmployeeEntity dtoToEntity(EmployeeDto employeeDto){
        return EmployeeEntity.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .gender(employeeDto.getGender())
                .birthDate(employeeDto.getBirthDate())
                .email(employeeDto.getEmail())
                .phoneNumber(employeeDto.getPhoneNumber())
                .address(employeeDto.getAddress())
                .salary(employeeDto.getSalary())
                .build();
    }

    public static EmployeeView entityToView(EmployeeEntity employee){
        return EmployeeView.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .gender(employee.getGender())
                .birthDate(employee.getBirthDate())
                .phoneNumber(employee.getPhoneNumber())
                .address(employee.getAddress())
                .salary(employee.getSalary())
                .positionId(employee.getPositionId())
                .build();

    }

    public static Set<EmployeeView> entityToViewList(Set<EmployeeEntity> entities){
        return entities.stream()
                .map(EmployeeMapper::entityToView)
                .collect(Collectors.toSet());
    }
}
