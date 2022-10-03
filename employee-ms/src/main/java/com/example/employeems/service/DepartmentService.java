package com.example.employeems.service;

import com.example.employeems.dao.entity.DepartmentEntity;
import com.example.employeems.model.dto.DepartmentDto;
import com.example.employeems.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DepartmentService {
 private final DepartmentRepository departmentRepository;
  public DepartmentEntity createDepartment(DepartmentDto departmentDto){
      DepartmentEntity department= new DepartmentEntity();
      department.setdepartmentname(departmentDto.getdepartmentname());
      return departmentRepository.save(department);
  }
  public DepartmentEntity findById(Long id){
      return departmentRepository.findById(id).get();
  }
public DepartmentEntity findDepartmentById(Long id){
      return (DepartmentEntity) departmentRepository.findDepartmentById(id);
}


   // public Department updateById(Long id) {return derpartmentRepository.updateById
   // }
}
