package com.github.matjanko.teksystem.contracts.services.impl;

import com.github.matjanko.teksystem.contracts.dto.project.ProjectRequest;
import com.github.matjanko.teksystem.contracts.dto.project.ProjectResponse;
import com.github.matjanko.teksystem.contracts.model.project.ProjectRepository;
import com.github.matjanko.teksystem.contracts.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper mapper;

    @Override
    public List<ProjectResponse> getAll() {
        return projectRepository.findAllByOrderByNumberDesc().stream()
                .map(p -> mapper.map(p, ProjectResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long add(@NotNull ProjectRequest request) {

        return 0L;
    }
}
