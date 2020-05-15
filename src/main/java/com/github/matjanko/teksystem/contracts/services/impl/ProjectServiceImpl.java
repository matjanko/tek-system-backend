package com.github.matjanko.teksystem.contracts.services.impl;

import com.github.matjanko.teksystem.contracts.dto.ProjectDto;
import com.github.matjanko.teksystem.contracts.model.project.ProjectRepository;
import com.github.matjanko.teksystem.contracts.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper mapper;

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.findAll().stream()
                .map(project -> mapper.map(project, ProjectDto.class))
                .collect(Collectors.toList());
    }
}
