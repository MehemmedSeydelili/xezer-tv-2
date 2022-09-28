package com.example.employeems.dao.entity;


import com.example.employeems.model.enums.Education;
import com.example.employeems.model.enums.FamilyStatus;
import com.example.employeems.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Integer age;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "nationality")
    private String nationality;

    private String email;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    private String address;

    private String fin;

    private Long pin;

    @Column(name = "education")
    @Enumerated(EnumType.STRING)
    private Education education;

    @Column(name = "family_status")
    @Enumerated(EnumType.STRING)
    private FamilyStatus familyStatus;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Double salary;

    @Column(name = "weekly_work_hours")
    private Long weeklyWorkHours;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "position_id")
    private Long positionId;

}
