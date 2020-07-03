package com.github.matjanko.teksystem.contracts.services;

import com.github.matjanko.teksystem.contracts.dto.project.ProjectRequest;
import com.github.matjanko.teksystem.contracts.dto.project.ProjectResponse;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface ProjectService {

    List<ProjectResponse> getAll();

    Long add(@NotNull ProjectRequest request);
}
