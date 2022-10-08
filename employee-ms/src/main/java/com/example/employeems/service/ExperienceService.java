package com.example.employeems.service;

import com.example.employeems.dao.entity.ExperienceEntity;
import com.example.employeems.dao.repository.ExperienceRepository;
import com.example.employeems.mapper.ExperienceMapper;
import com.example.employeems.model.dto.ExperienceDto;
import com.example.employeems.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

import static com.example.employeems.model.constant.ExceptionConstants.EXPERIENCE_NOT_FOUND_CODE;
import static com.example.employeems.model.constant.ExceptionConstants.EXPERIENCE_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExperienceService {

    private final ExperienceRepository repository;
    private final EmployeeService employeeService;

    public TreeSet<ExperienceEntity> getAllExperiences() {

        return null;
    }

    public void createExperience(Long employeeId, ExperienceDto experienceDto) {
        log.info("ExperienceService.createExperience.start");
        if (employeeService.getEmployee(employeeId) != null) {
            log.info("ExperienceService.createExperience.if-case");
            var experienceEntity = ExperienceMapper.dtoToEntity(experienceDto);
            experienceEntity.setEmployeeId(employeeId);
            repository.save(experienceEntity);
        }
        log.info("ExperienceService.createExperience.end");
    }

    public ExperienceEntity updateExperience(Long id, ExperienceDto experienceDto) {
        log.info("ExperienceService.updateExperience.start");
        var experience = fetcExperienceIfExist(id);
        experience.setWorkplace(experienceDto.getWorkplace());
        experience.setPosition(experienceDto.getPosition());
        experience.setStartDate(experienceDto.getStartDate());
        experience.setEndDate(experienceDto.getEndDate());
        repository.save(experience);
        log.info("ExperienceService.updateExperience.end");
        return experience;
    }

    public void deleteExperience(Long id) {
        log.info("ExperienceService.deleteExperience.start");
        repository.delete(fetcExperienceIfExist(id));
        log.info("ExperienceService.deleteExperience.end");
    }

    private ExperienceEntity fetcExperienceIfExist(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("ExperienceService.fetcExperienceIfExist.error id: {}", id);
            throw new NotFoundException(EXPERIENCE_NOT_FOUND_CODE, String.format(EXPERIENCE_NOT_FOUND_MESSAGE, id));
        });
    }
}
