package com.example.employeems.controller;

import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.model.dto.EmployeeDto;
import com.example.employeems.model.view.EmployeeView;
import com.example.employeems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<Set<EmployeeView>> getEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeView> getById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(id));
    }
//
//    @PostMapping("{positionId}")
//        public ResponseEntity<EmployeeView> createEmployee(/*@PathVariable(name = "positionId") Long positionId,*/
//                                                          @RequestBody EmployeeDto employeeDto){
//         return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeDto));
//    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeView> updpate(@PathVariable("id") Long id , @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id,employeeDto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

}

