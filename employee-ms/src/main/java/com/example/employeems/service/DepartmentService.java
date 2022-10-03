package com.example.employeems.service;

import com.example.employeems.entity.Department;
import com.example.employeems.model.dto.DepartmentDto;
import com.example.employeems.repository.DepartmentRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DepartmentService {
 private final DepartmentRepository departmentRepository;
  public Department createDepartment(DepartmentDto departmentDto){
      Department department= new Department();
      department.setdepartmentname(departmentDto.getdepartmentname());
      return departmentRepository.save(department);
  }
  public Department findById(Long id){
      return departmentRepository.findById(id).get();
  }
public Department findDepartmentById(Long id){
      return (Department) departmentRepository.findDepartmentById(id);
}


   // public Department updateById(Long id) {return derpartmentRepository.updateById
   // }
}
