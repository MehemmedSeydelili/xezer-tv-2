package com.example.employeems.service.impl;

import com.example.employeems.exception.EmployeeNotFoundException;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;
import com.example.employeems.repository.EmployeeRepository;
import com.example.employeems.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeView> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeView getEmployeeById(Long id) {
        /*employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException
                (String.format("Employee not found with id - %s", id)))*/
        return null;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto updatEmployee(Long id, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
