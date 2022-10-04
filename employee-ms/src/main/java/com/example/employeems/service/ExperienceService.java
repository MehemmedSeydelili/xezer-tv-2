package com.example.employeems.service;

import com.example.employeems.dao.entity.ExperienceEntity;
import com.example.employeems.model.exception.NotFoundException;
import com.example.employeems.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.employeems.model.constant.ExceptionConstants.EXPERIENCE_NOT_FOUND_CODE;
import static com.example.employeems.model.constant.ExceptionConstants.EXPERIENCE_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExperienceService {

    private final ExperienceRepository repository;

    private ExperienceEntity fetcExperienceIfExist(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("ExperienceService.fetcExperienceIfExist.error id: {}", id);
            throw new NotFoundException(EXPERIENCE_NOT_FOUND_CODE, String.format(EXPERIENCE_NOT_FOUND_MESSAGE, id));
        });
    }
}
