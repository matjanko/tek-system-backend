package com.github.matjanko.teksystem.dictonaries.api;

import com.github.matjanko.teksystem.dictonaries.model.Dictionary;
import com.github.matjanko.teksystem.dictonaries.model.projectstage.ProjectStage;
import com.github.matjanko.teksystem.dictonaries.model.projectstage.ProjectStageRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dictionaries")
@Api(tags = "Dictionaries")
@RequiredArgsConstructor
public class DictionaryController {

    private final ProjectStageRepository projectStageRepository;

    @GetMapping("/project-stages")
    @ApiOperation(value = "Get project stages")
    public ResponseEntity<List<ProjectStage>> getAllProjectStages() {
        List<ProjectStage> projectStages = projectStageRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Dictionary::getName))
                .collect(Collectors.toList());

        return new ResponseEntity<>(projectStages, HttpStatus.OK);
    }

}
