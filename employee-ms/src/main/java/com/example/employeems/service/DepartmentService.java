package com.example.employeems.service;

import com.example.employeems.dao.entity.DepartmentEntity;
import com.example.employeems.dao.repository.DepartmentRepository;
import com.example.employeems.mapper.DepartmentMapper;
import com.example.employeems.model.dto.DepartmentDto;
import com.example.employeems.model.exception.NotFoundException;
import com.example.employeems.model.view.DepartmentView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.employeems.model.constant.ExceptionConstants.DEPARTMENT_NOT_FOUND_CODE;
import static com.example.employeems.model.constant.ExceptionConstants.DEPARTMENT_NOT_FOUND_MESSAGE;


@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentView getDepartment(Long id) {
        log.info("DepartmentService.getDepartment.start id: {}", id);
        return DepartmentMapper.entityToView(fetcDepartmentIfExist(id));
    }

    public List<DepartmentView> getAllDepartments() {
        log.info("DepartmentService.getAllDepartments.start");
        var departmentList = repository.findAllByDeletedIsFalse();
        if (departmentList.isEmpty()) {
            log.error("DepartmentService.getAllDepartments.if case");
            throw new NotFoundException(DEPARTMENT_NOT_FOUND_CODE, "There are not any department!");
        }
        return DepartmentMapper.entitiesToViewList(departmentList);
    }

    public void createDepartment(DepartmentDto departmentDto) {
        log.info("DepartmentService.createDepartment.start");
        var department = DepartmentMapper.dtoToEntity(departmentDto);
        repository.save(department);
        log.info("DepartmentService.createDepartment.end");
    }

    public DepartmentView updateDepartment(Long id, DepartmentDto departmentDto) {
        log.info("DepartmentService.updateDepartment.start id: {}", id);
        var department = fetcDepartmentIfExist(id);
        department.setName(departmentDto.getName());
        repository.save(department);
        log.info("DepartmentService.updateDepartment.end id: {}", id);
        return DepartmentMapper.entityToView(department);
    }

    public void deleteDepartment(Long id) {
        log.info("DepartmentService.deleteDepartment.start id: {}", id);
        var department = fetcDepartmentIfExist(id);
        department.setIsDeleted(true);
        repository.save(department);
        log.info("DepartmentService.deleteDepartment.end id: {}", id);
    }


    private DepartmentEntity fetcDepartmentIfExist(Long id) {
        return repository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> {
                    log.error("DepartmentService.fetcDepartmentIfExist.error id: {}", id);
                    throw new NotFoundException(DEPARTMENT_NOT_FOUND_CODE,
                            String.format(DEPARTMENT_NOT_FOUND_MESSAGE, id));
                });
    }


}
