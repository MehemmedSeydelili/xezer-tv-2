package com.example.employeems.controller;

import com.example.employeems.dao.entity.DepartmentEntity;
import com.example.employeems.model.dto.DepartmentDto;
import com.example.employeems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentservice;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentservice.createDepartment(departmentDto));
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentEntity> getById(@PathVariable("departmentId") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentservice.findById(id));
    }
}
   /* @PutMapping("/{departmentId}")
    public Department updatedepartment(@PathVariable("departmentId") Long id,@RequestBody Department department){
        return ResponseEntity.status(HttpStatus.OK).body(departmentservice.updateById(id));  }

}*/
