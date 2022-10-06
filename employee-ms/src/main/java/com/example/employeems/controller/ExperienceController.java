package com.example.employeems.controller;

import com.example.employeems.dao.entity.ExperienceEntity;
import com.example.employeems.model.dto.ExperienceDto;
import com.example.employeems.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/experiences")
public class ExperienceController {

    private final ExperienceService service;

    @GetMapping("{employeeId}")
    public Set<ExperienceEntity> getExperiences(@PathVariable(name = "employeeId") Long employeeId) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createExperience(@Valid @RequestBody ExperienceDto experience) {

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExperienceEntity updateExperience(@PathVariable Long id, @RequestBody ExperienceDto experience) {
        return null;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExperience(Long id) {

        service.deleteExperience(id);
    }


}
