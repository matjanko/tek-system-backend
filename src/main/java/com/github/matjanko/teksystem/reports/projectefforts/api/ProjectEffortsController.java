package com.github.matjanko.teksystem.reports.projectefforts.api;

import com.github.matjanko.teksystem.reports.projectefforts.dto.ProjectEffortResponse;
import com.github.matjanko.teksystem.reports.projectefforts.model.ProjectEffortRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports/project-efforts")
@Api(tags = "Project efforts")
@RequiredArgsConstructor
public class ProjectEffortsController {

    private final ProjectEffortRepository repository;
    private final ModelMapper mapper;

    @GetMapping
    @ApiOperation(value = "Get all project effort")
    public ResponseEntity<List<ProjectEffortResponse>> getAllProjectEffort() {
        List<ProjectEffortResponse> projectefforts = repository.findAll().stream()
                .map(p -> mapper.map(p, ProjectEffortResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(projectefforts, HttpStatus.OK);
    }
}
