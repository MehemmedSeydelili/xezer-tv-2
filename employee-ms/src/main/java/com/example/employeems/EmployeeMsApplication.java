package com.example.employeems;

import com.example.employeems.dao.entity.DepartmentEntity;
import com.example.employeems.dao.entity.EmployeeEntity;
import com.example.employeems.dao.entity.ExperienceEntity;
import com.example.employeems.dao.entity.PositionEntity;
import com.example.employeems.dao.repository.DepartmentRepository;
import com.example.employeems.dao.repository.EmployeeRepository;
import com.example.employeems.dao.repository.ExperienceRepository;
import com.example.employeems.dao.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class EmployeeMsApplication implements CommandLineRunner {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        DepartmentEntity departmentIt = DepartmentEntity.builder()
                                                        .name("IT")
                                                        .isDeleted(false)
                                                        .build();
        departmentRepository.save(departmentIt);
        DepartmentEntity departmentFinance = DepartmentEntity.builder()
                                                             .name("Finance")
                                                             .isDeleted(false)
                                                             .build();
        departmentRepository.save(departmentFinance);

        PositionEntity position1 = PositionEntity.builder()
                                                 .department(departmentIt)
                                                 .name("Java back-end developer")
                                                 .isDeleted(false)
                                                 .build();
        positionRepository.save(position1);


        PositionEntity position2 = PositionEntity.builder()
                                                 .department(departmentIt)
                                                 .name("React front-end developer")
                                                 .isDeleted(false)
                                                 .build();
        positionRepository.save(position2);
        PositionEntity position3 = PositionEntity.builder()
                                                 .department(departmentFinance)
                                                 .name("Chief accountant")
                                                 .isDeleted(false)
                                                 .build();
        positionRepository.save(position3);

        EmployeeEntity employee1 = EmployeeEntity.builder()
                                                 .firstName("Ibrahim")
                                                 .lastName("Nazarov")
                                                 .birthDate(LocalDate.of(1990, 4, 5))
                                                 .email("ibrahim@gmail.com")
                                                 .phoneNumber("123456789")
                                                 .address("Baki")
                                                 .salary(1700.0)
                                                 .isDeleted(false)
                                                 .position(position1)
                                                 .build();
        employeeRepository.save(employee1);

//        ExperienceEntity experienceI = ExperienceEntity.builder()
//                                                       .employeeId(1L)
//                                                       .workplace("Arka")
//                                                       .position("accountant")
//                                                       .startDate(LocalDate.of(2020, 3, 22))
//                                                       .endDate(LocalDate.of(2021, 1, 30))
//                                                       .build();
//        experienceRepository.save(experienceI);


    }
}
