package com.example.employeems.controller;

import com.example.employeems.model.dto.DepartmentDto;
import com.example.employeems.model.view.DepartmentView;
import com.example.employeems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/departments")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping("/{id}")
    public DepartmentView getDepartment(@PathVariable Long id) {
        return service.getDepartment(id);
    }

    @GetMapping
    public List<DepartmentView> getAllDepartments() {
        return service.getAllDepartments();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        service.createDepartment(departmentDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentView updateDepartment(@PathVariable Long id, @Valid @RequestBody DepartmentDto departmentDto) {

        return service.updateDepartment(id, departmentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable Long id) {
        service.deleteDepartment(id);
    }


}