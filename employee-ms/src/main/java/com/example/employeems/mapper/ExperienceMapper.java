package com.example.employeems.mapper;

import com.example.employeems.dao.entity.ExperienceEntity;
import com.example.employeems.model.dto.ExperienceDto;

public class ExperienceMapper {

    public static ExperienceEntity dtoToEntity(ExperienceDto dto) {
        return ExperienceEntity.builder()
                               .workplace(dto.getWorkplace())
                               .position(dto.getPosition())
                               .startDate(dto.getStartDate())
                               .endDate(dto.getEndDate())
                               .build();
    }


}
