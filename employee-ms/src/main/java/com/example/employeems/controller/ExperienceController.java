package com.example.employeems.controller;

import com.example.employeems.dao.entity.ExperienceEntity;
import com.example.employeems.model.dto.ExperienceDto;
import com.example.employeems.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/experiences")
public class ExperienceController {

    private final ExperienceService service;

    @GetMapping("/{employeeId}")
    public List<ExperienceEntity> getAllExperiences(@PathVariable(name = "employeeId") Long employeeId) {
        return service.getAllExperiences(employeeId);
    }

    @PostMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createExperience(@PathVariable(name = "employeeId") Long employeeId,
                                 @Valid @RequestBody ExperienceDto experience) {
        service.createExperience(employeeId, experience);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExperienceEntity updateExperience(@PathVariable(value = "id") Long id,
                                             @RequestBody ExperienceDto experience) {
        return service.updateExperience(id, experience);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExperience(@PathVariable(value = "id") Long id) {
        service.deleteExperience(id);
    }


}
