package com.example.employeems.service;

import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;

import java.util.List;

public interface IEmployeeService {
     List<EmployeeView> getAllEmployee();
     EmployeeView getEmployeeById(Long id);
     EmployeeDto createEmployee(EmployeeDto employeeDto);
     EmployeeDto updatEmployee(Long id, EmployeeDto employeeDto);
     void deleteEmployee(Long id);

}
