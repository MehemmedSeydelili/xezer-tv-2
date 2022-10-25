package com.example.employeems.mapper;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeEntity dtoToEntity(EmployeeDto dto) {
        return EmployeeEntity.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .gender(dto.getGender())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .salary(dto.getSalary())
                .isDeleted(false)
                .build();
    }

    public static EmployeeView entityToView(EmployeeEntity entity) {
        return EmployeeView.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender())
                .birthDate(entity.getBirthDate())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .salary(entity.getSalary())
                .position(PositionMapper.entityToView(entity.getPosition()))
                .build();

    }

    public static List<EmployeeView> entityToViewList(List<EmployeeEntity> entities) {
        return entities.stream()
                .map(EmployeeMapper::entityToView)
                .collect(Collectors.toList());
    }
}
