package com.example.employeems.controller;

import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;
import com.example.employeems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeView>> getEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeView> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployee(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeView> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(employeeDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeView> updpateEmployee(@PathVariable("id") Long id,@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateEmployee(id, employeeDto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteEmployee(id);
    }

}

