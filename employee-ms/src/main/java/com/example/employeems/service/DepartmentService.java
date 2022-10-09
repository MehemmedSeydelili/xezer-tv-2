package com.example.employeems.service;

import com.example.employeems.dao.entity.DepartmentEntity;
import com.example.employeems.dao.repository.DepartmentRepository;
import com.example.employeems.mapper.DepartmentMapper;
import com.example.employeems.model.dto.DepartmentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentService departmentService;
//  public DepartmentEntity createDepartment(DepartmentDto departmentDto){
//      DepartmentEntity department= new DepartmentEntity();
//      department.setdepartmentname(departmentDto.getdepartmentname());
//      return departmentRepository.save(department);
//  }

    public DepartmentEntity findById(Long id) {
        return departmentRepository.findById(id).get();
    }

    /*public DepartmentEntity findDepartmentById(Long id){
          return (DepartmentEntity) departmentRepository.findDepartmentById(id);
    }*/
    public List<DepartmentEntity> getAllDepartments(long id) {
        log.info("DepartmentService.getAllDepartments.start");
        return departmentRepository.findAllDepartmentsById(id);
    }

    public void createDepartment(Long id, DepartmentDto departmentDto) {
        log.info("DepartmentService.createDepartment.start");
        if (departmentService.getDepartment(id) != null) {
            log.info("DepartmenytService.createDepartment.if-case");
            var departmentEntity = DepartmentMapper.dtoToEntity(departmentDto);
            departmentEntity.setName(departmentEntity.getName());
            departmentRepository.save(departmentEntity);
        }
        log.info("DepartmentSevice.createDepartment.end");
    }

    private Object getDepartment(Long id) {
        return null;
    }


     public DepartmentEntity updateById(Long id) {
        return (DepartmentEntity) departmentRepository.findDepartmentById(id);
     }
}
