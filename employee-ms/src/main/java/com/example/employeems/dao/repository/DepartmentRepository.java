package com.example.employeems.dao.repository;

import com.example.employeems.dao.entity.DepartmentEntity;
import com.example.employeems.dao.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    @Query(nativeQuery = true, value = "select * from departments where is_deleted=false")
    List<DepartmentEntity> findAllByDeletedIsFalse();

    Optional<DepartmentEntity> findByIdAndIsDeletedFalse(Long id);


}
