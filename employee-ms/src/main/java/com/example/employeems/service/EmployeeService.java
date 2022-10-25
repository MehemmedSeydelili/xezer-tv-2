package com.example.employeems.service;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.dao.repository.EmployeeRepository;
import com.example.employeems.mapper.EmployeeMapper;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.exception.NotFoundException;
import com.example.employeems.model.view.EmployeeView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.employeems.model.constant.ExceptionConstants.EMPLOYEE_NOT_FOUND_CODE;
import static com.example.employeems.model.constant.ExceptionConstants.EMPLOYEE_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository repository;
    private final PositionService positionService;


    public EmployeeView getEmployee(Long id) {
        return EmployeeMapper.entityToView(fetchEmployeeIfExist(id));
    }

    public List<EmployeeView> getAllEmployees() {
        var employeeList = repository.findAllByDeletedIsFalse();
        if (employeeList.isEmpty()) {
            throw new NotFoundException(EMPLOYEE_NOT_FOUND_CODE, "There are not any employee!");
        }
        return EmployeeMapper.entityToViewList(employeeList);
    }

    public EmployeeView createEmployee(EmployeeDto employeeDto) {
        var position = positionService.fetchPositionIfExists(employeeDto.getPosition().getId());
        var employee = EmployeeMapper.dtoToEntity(employeeDto);
        employee.setPosition(position);
        repository.save(employee);
        return EmployeeMapper.entityToView(employee);
    }

    public EmployeeView updateEmployee(Long id, EmployeeDto dto) {
        var employee = fetchEmployeeIfExist(id);
        var position = positionService.fetchPositionIfExists(dto.getPosition().getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setGender(dto.getGender());
        employee.setBirthDate(dto.getBirthDate());
        employee.setEmail(dto.getEmail());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setAddress(dto.getAddress());
        employee.setSalary(dto.getSalary());
        employee.setPosition(position);
        repository.save(employee);

        return EmployeeMapper.entityToView(employee);
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

