package com.example.employeems.service;

import com.example.employeems.dao.entity.PositionEntity;
import com.example.employeems.dao.repository.PositionRepository;
import com.example.employeems.mapper.PositionMapper;
import com.example.employeems.model.dto.PositionDto;
import com.example.employeems.model.exception.NotFoundException;
import com.example.employeems.model.view.PositionView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.employeems.model.constant.ExceptionConstants.POSITION_NOT_FOUND_CODE;
import static com.example.employeems.model.constant.ExceptionConstants.POSITION_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionService {

    private final PositionRepository repository;
    private final DepartmentService departmentService;

    public PositionView getPosition(Long id) {
        return PositionMapper.entityToView(fetchPositionIfExists(id));
    }

    public List<PositionView> getAllPositions() {
        var positionList = repository.findAllByDeletedIsFalse();
        if (positionList.isEmpty()) {
            throw new NotFoundException(POSITION_NOT_FOUND_CODE, "There are not any position!");
        }
        return PositionMapper.entitiesToViewList(positionList);
    }

    public List<PositionView> getAllPositionsByDepartment(Long departmentId) {
        departmentService.getDepartment(departmentId);
        var positionList = repository.findAllByDepartment_IdAndIsDeletedFalse(departmentId);
        if (positionList.isEmpty()) {
            throw new NotFoundException(POSITION_NOT_FOUND_CODE, "There are not any position!");
        }
        return PositionMapper.entitiesToViewList(positionList);
    }

    public void createPosition(PositionDto dto) {
        var department = departmentService.fetcDepartmentIfExist(dto.getDepartment().getId());
        var position = PositionMapper.dtoToEntity(dto);
        position.setDepartment(department);
        repository.save(position);
    }

    public PositionView updatePosition(Long id, PositionDto dto) {
        var position = fetchPositionIfExists(id);
        var department = departmentService.fetcDepartmentIfExist(dto.getDepartment().getId());
        position.setName(dto.getName());
        position.setDepartment(department);
        repository.save(position);
        return PositionMapper.entityToView(position);
    }

    public void deletePosition(Long id) {
        var position = fetchPositionIfExists(id);
        position.setIsDeleted(true);
        repository.save(position);
    }

    PositionEntity fetchPositionIfExists(Long id) {

        return repository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> {
                    log.error("PositionService.fetchPositionIfExists.error id: {}", id);
                    throw new NotFoundException(POSITION_NOT_FOUND_CODE,
                            String.format(POSITION_NOT_FOUND_MESSAGE, id));
                });
    }


}
