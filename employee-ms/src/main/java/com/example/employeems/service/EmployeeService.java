package com.example.employeems.service;

import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;
import com.example.employeems.dao.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService{

    private final EmployeeRepository employeeRepository;

    public List<EmployeeView> getAllEmployee() {
        return null;
    }

    public EmployeeView getEmployeeById(Long id) {
        /*employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException
                (String.format("Employee not found with id - %s", id)))*/
        return null;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }

    public EmployeeDto updatEmployee(Long id, EmployeeDto employeeDto) {
        return null;
    }

    public void deleteEmployee(Long id) {

    }
}
