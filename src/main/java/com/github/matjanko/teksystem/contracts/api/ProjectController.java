package com.github.matjanko.teksystem.contracts.api;

import com.github.matjanko.teksystem.contracts.dto.ProjectDto;
import com.github.matjanko.teksystem.contracts.model.project.ProjectRepository;
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
@RequestMapping("/api/projects")
@Api(tags = "Projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ModelMapper mapper;

    @GetMapping
    @ApiOperation(value = "Get all projects")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        List<ProjectDto> projects = projectRepository.findAll().stream()
                .map(p -> mapper.map(p, ProjectDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
