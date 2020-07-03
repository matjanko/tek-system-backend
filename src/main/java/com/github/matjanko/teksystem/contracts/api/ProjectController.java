package com.github.matjanko.teksystem.contracts.api;

import com.github.matjanko.teksystem.contracts.dto.project.ProjectRequest;
import com.github.matjanko.teksystem.contracts.dto.project.ProjectResponse;
import com.github.matjanko.teksystem.contracts.services.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
@Api(tags = "Projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ModelMapper mapper;

    @GetMapping
    @ApiOperation(value = "Get all projects")
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<ProjectResponse> projects = projectService.getAll().stream()
                .map(p -> mapper.map(p, ProjectResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Add project")
    public ResponseEntity<?> postProject(@RequestBody ProjectRequest project) {
        try {
            Long projectId = projectService.add(project);
            return new ResponseEntity<>(projectId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
