package com.example.employeems.service;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.dao.entity.PositionEntity;
import com.example.employeems.dao.repository.EmployeeRepository;
import com.example.employeems.dao.repository.PositionRepository;
import com.example.employeems.mapper.EmployeeMapper;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.exception.NotFoundException;
import com.example.employeems.model.view.EmployeeView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.employeems.model.constant.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository repository;
    private final PositionRepository positionRepository;


    public EmployeeView getEmployee(Long id) {
        return EmployeeMapper.entityToView(fetchEmployeeIfExist(id));
    }

    public Set<EmployeeView> getAllEmployees() {
        Set<EmployeeEntity> employees = repository.findAllByDeletedIsFalse();
        return EmployeeMapper.entityToViewList(employees);
    }

//    public EmployeeView createEmployee(EmployeeDto employeeDto) {
//
//        PositionEntity position = positionRepository.findById(employeeDto.getPositionId()).orElseThrow(() -> {
//            throw new NotFoundException(POSITION_NOT_FOUND_CODE, String.format(POSITION_NOT_FOUND_MESSAGE));
//        });
//
//        EmployeeEntity employees = EmployeeMapper.dtoToEntity(employeeDto);
//        employees.setPosition(position);
//        repository.save(employees);
//
//        return EmployeeMapper.entityToView(employees);
//    }

    public EmployeeView updateEmployee(Long id, EmployeeDto employeeDto) {

        return null;
    }

    public void deleteEmployee(Long id) {
        EmployeeEntity employee = fetchEmployeeIfExist(id);
        employee.setIsDeleted(true);
        repository.save(employee);
    }

    private EmployeeEntity fetchEmployeeIfExist(Long id) {
        return repository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> {
            log.error("EmployeeService.fetcEmployeeIfExist.error id: {}", id);
            throw new NotFoundException(EMPLOYEE_NOT_FOUND_CODE, String.format(EMPLOYEE_NOT_FOUND_MESSAGE, id));
        });
    }
}

