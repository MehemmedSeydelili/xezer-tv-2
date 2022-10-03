package com.example.employeems.service;

import com.example.employeems.entity.Position;
import com.example.employeems.model.dto.PositionDto;
import com.example.employeems.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    public Position createPosition(PositionDto positionDto){
        //constructor
        Position position = new Position();
        position.setName(positionDto.getName());
    return positionRepository.save(position);
    }
    public Position findbyId(Long id){return positionRepository.findById(id).get();}
    public Position findNameById(Long id){return (Position) positionRepository.findNameById(id);}
}
