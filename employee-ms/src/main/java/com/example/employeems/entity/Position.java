package com.example.employeems.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "position_name")
    private String name;
    @Column(name = "department_id")
    private Long departmenId;



}
