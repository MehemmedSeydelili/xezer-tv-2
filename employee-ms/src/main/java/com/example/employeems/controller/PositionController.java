package com.example.employeems.controller;

import com.example.employeems.model.dto.PositionDto;
import com.example.employeems.model.view.PositionView;
import com.example.employeems.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/positions")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService service;

    @GetMapping
    public List<PositionView> getAllPositions() {
        return service.getAllPositions();
    }

    @GetMapping("/{departmentId}")
    public List<PositionView> getAllPositionsByDepartment(@PathVariable(name = "departmentId") Long departmentId) {
        return service.getAllPositionsByDepartment(departmentId);
    }

    @GetMapping("/position/{id}")
    public PositionView getPosition(@PathVariable Long id) {
        return service.getPosition(id);
    }

    @PostMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPosition(@PathVariable(name = "departmentId") Long departmentId, @Valid @RequestBody PositionDto positionDto) {
        service.createPosition(departmentId, positionDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionView updatePosition(@PathVariable Long id, @RequestBody PositionDto positionDto) {
        return service.updatePosition(id, positionDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePosition(@PathVariable Long id) {
        service.deletePosition(id);
    }
}
