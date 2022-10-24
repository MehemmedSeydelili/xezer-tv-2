package com.example.employeems.mapper;

import com.example.employeems.dao.entity.PositionEntity;
import com.example.employeems.model.dto.PositionDto;
import com.example.employeems.model.view.PositionView;

import java.util.List;
import java.util.stream.Collectors;

public class PositionMapper {

    public static PositionEntity dtoToEntity(PositionDto dto) {
        return PositionEntity.builder()
                .name(dto.getName())
                .build();
    }

    public static PositionView entityToView(PositionEntity entity) {
        return PositionView.builder()
                .id(entity.getId())
                .name(entity.getName())
                .department(DepartmentMapper.entityToView(entity.getDepartment()))
                .build();
    }

    public static List<PositionView> entitiesToViewList(List<PositionEntity> entities) {
        return entities.stream().map(PositionMapper::entityToView).collect(Collectors.toList());
    }
}
