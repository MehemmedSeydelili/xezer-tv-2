package com.example.employeems.dao.repository;

import com.example.employeems.dao.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    List<ExperienceEntity> findAllByEmployeeIdOrderByStartDateDesc(Long employeeId);
}
