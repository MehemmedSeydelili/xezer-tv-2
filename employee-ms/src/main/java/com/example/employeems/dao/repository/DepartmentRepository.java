package com.example.employeems.dao.repository;

import com.example.employeems.dao.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    List<DepartmentEntity> findDepartmentById(Long id);
}
