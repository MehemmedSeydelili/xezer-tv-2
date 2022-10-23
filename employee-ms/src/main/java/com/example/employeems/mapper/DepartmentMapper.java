package com.example.employeems.mapper;

import com.example.employeems.dao.entity.DepartmentEntity;
import com.example.employeems.model.dto.DepartmentDto;
import com.example.employeems.model.view.DepartmentView;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentMapper {

    public static DepartmentView entityToView(DepartmentEntity entity) {
        return DepartmentView.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static DepartmentEntity dtoToEntity(DepartmentDto dto) {
        return DepartmentEntity.builder()
                .name(dto.getName())
                .isDeleted(false)
                .build();
    }

    public static List<DepartmentView> entitiesToViewList(List<DepartmentEntity> entities) {
        return entities.stream()
                .map(DepartmentMapper::entityToView)
                .collect(Collectors.toList());
    }
}
