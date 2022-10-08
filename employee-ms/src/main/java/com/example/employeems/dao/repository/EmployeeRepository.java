package com.example.employeems.dao.repository;

import com.example.employeems.dao.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query(nativeQuery = true, value = "select * from employees where is_deleted false")
    Set<EmployeeEntity> findAllByDeletedIsFalse();

    Optional<EmployeeEntity> findByIdAndIsDeletedFalse(Long id);
}
