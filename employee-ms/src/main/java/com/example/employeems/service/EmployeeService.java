package com.example.employeems.service;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.dao.entity.PositionEntity;
import com.example.employeems.dao.repository.PositionRepository;
import com.example.employeems.mapper.EmployeeMapper;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.exception.NotFoundException;
import com.example.employeems.model.view.EmployeeView;
import com.example.employeems.dao.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.employeems.model.constant.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;

    private EmployeeEntity fetchEmployeeIfExist(Long id) {
        return employeeRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> {
            log.error("EmployeeService.fetcEmployeeIfExist.error id: {}", id);
            throw new NotFoundException(EMPLOYEE_NOT_FOUND_CODE, String.format(EMPLOYEE_NOT_FOUND_MESSAGE, id));
        });
    }

    public EmployeeView getEmployee(Long id) {
        return EmployeeMapper.entityToView(fetchEmployeeIfExist(id));
    }

    public Set<EmployeeView> getAllEmployees() {
        Set<EmployeeEntity> employees = employeeRepository.findAllByDeletedIsFalse();
        return EmployeeMapper.entityToViewList(employees);
    }

    public EmployeeView createEmployee(EmployeeDto employeeDto) {

        PositionEntity position = positionRepository.findById(employeeDto.getPositionId()).orElseThrow(() -> {
            throw new NotFoundException(POSITION_NOT_FOUND_CODE, String.format(POSITION_NOT_FOUND_MESSAGE));
        });

        EmployeeEntity employees = EmployeeMapper.dtoToEntity(employeeDto);
        employees.setPosition(position);
        employees.setPositionId(position.getId());
        employeeRepository.save(employees);

        return EmployeeMapper.entityToView(employees);
    }

    public EmployeeView updateEmployee(Long id, EmployeeDto employeeDto) {

        fetchEmployeeIfExist(id);

        EmployeeEntity employee = EmployeeMapper.dtoToEntity(employeeDto);
        employeeRepository.save(employee);
        return EmployeeMapper.entityToView(employee);
    }

    public void deleteEmployee(Long id) {
        fetchEmployeeIfExist(id);
        employeeRepository.deleteById(id);
    }
}

