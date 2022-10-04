package com.example.employeems.repository;

import com.example.employeems.dao.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity,Long> {
    List<PositionEntity> findNameById(Long id);
}