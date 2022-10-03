package com.example.employeems.service;

import com.example.employeems.dao.entity.PositionEntity;
import com.example.employeems.model.dto.PositionDto;
import com.example.employeems.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    public PositionEntity createPosition(PositionDto positionDto){
        //constructor
        PositionEntity position = new PositionEntity();
        position.setName(positionDto.getName());
    return positionRepository.save(position);
    }
    public PositionEntity findbyId(Long id){return positionRepository.findById(id).get();}
    public PositionEntity findNameById(Long id){return (PositionEntity) positionRepository.findNameById(id);}
}
