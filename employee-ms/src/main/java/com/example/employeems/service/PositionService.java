package com.example.employeems.service;

import com.example.employeems.dao.entity.PositionEntity;
import com.example.employeems.model.dto.PositionDto;
import com.example.employeems.dao.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
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

    public void deletePosition(Long id){
        PositionEntity entity =fetchPositionIfExists(id);
        entity.setIsDeleted(true);
        positionRepository.save(entity);
    }

    private PositionEntity fetchPositionIfExists(Long id) {
        return null;
    }
}
