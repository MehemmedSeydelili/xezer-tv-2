package com.example.employeems.service;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.dao.entity.PositionEntity;
import com.example.employeems.mapper.EmployeeMapper;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.exception.NotFoundException;
import com.example.employeems.model.view.EmployeeView;
import com.example.employeems.dao.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.employeems.model.constant.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionService positionService;

    private EmployeeEntity fetchEmployeeIfExist(Long id) {
        return employeeRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> {
            log.error("EmployeeService.fetcEmployeeIfExist.error id: {}", id);
            throw new NotFoundException(EMPLOYEE_NOT_FOUND_CODE, String.format(EMPLOYEE_NOT_FOUND_MESSAGE, id));
        });
    }

    public EmployeeView getEmployee(Long id) {
        return EmployeeMapper.entityToView(fetchEmployeeIfExist(id));
    }

    public Set<EmployeeView> getAll() {
        Set<EmployeeEntity> employees = employeeRepository.findAllByDeletedIsFalse();
        return EmployeeMapper.entityToViewList(employees);
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto, Long positionId) {
          PositionEntity positionEntity= positionService.getPosition(positionId);
          EmployeeMapper.dtoToEntity(employeeDto,positionEntity);

          return employeeDto;
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        return null;
    }

    public void deleteEmployee(Long id) {
        EmployeeEntity entity = fetchEmployeeIfExist(id);
        entity.setIsDeleted(true);
        employeeRepository.save(entity);
    }

}

