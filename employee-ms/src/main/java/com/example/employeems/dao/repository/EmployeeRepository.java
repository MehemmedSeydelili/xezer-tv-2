package com.example.employeems.dao.repository;

import com.example.employeems.dao.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<String> findByfirstName(String name);
    void deleteByfirstName(String name);
}
