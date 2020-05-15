package com.github.matjanko.teksystem.contracts.services;

import com.github.matjanko.teksystem.contracts.dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    List<ProjectDto> getAll();

}
