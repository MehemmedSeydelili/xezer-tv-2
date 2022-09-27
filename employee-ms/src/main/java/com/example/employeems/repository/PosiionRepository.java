package com.example.employeems.repository;

import com.example.employeems.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosiionRepository extends JpaRepository<Position,Long> {
}
