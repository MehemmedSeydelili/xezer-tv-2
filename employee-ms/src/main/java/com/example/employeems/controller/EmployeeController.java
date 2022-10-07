package com.example.employeems.controller;

import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;
import com.example.employeems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<Set<EmployeeView>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeView> getById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(id));
    }

    @PostMapping
        public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updpate(@PathVariable("id") Long id , @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id,employeeDto));
    }

    @DeleteMapping("{id}")
    public void delete(Long id){
        employeeService.deleteEmployee(id);
    }

}

