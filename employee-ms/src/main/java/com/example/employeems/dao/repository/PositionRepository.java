package com.example.employeems.dao.repository;

import com.example.employeems.dao.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Long> {

    Optional<PositionEntity> findByIdAndIsDeletedFalse(Long id);

    @Query(nativeQuery = true, value = "select * from positions where is_deleted=false")
    List<PositionEntity> findAllByDeletedIsFalse();

    List<PositionEntity> findAllByDepartment_IdAndIsDeletedFalse(Long departmentId);

}


