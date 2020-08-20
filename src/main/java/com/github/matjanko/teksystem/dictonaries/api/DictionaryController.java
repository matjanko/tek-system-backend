package com.github.matjanko.teksystem.dictonaries.api;

import com.github.matjanko.teksystem.dictonaries.dto.DictionaryDto;
import com.github.matjanko.teksystem.dictonaries.dto.ProjectDictionaryDto;
import com.github.matjanko.teksystem.dictonaries.model.Dictionary;
import com.github.matjanko.teksystem.dictonaries.model.activity.ActivityCategoryDictionaryRepository;
import com.github.matjanko.teksystem.dictonaries.model.activity.ActivitySubcategoryDictionaryRepository;
import com.github.matjanko.teksystem.dictonaries.model.customer.CustomerDictionaryRepository;
import com.github.matjanko.teksystem.dictonaries.model.employee.EmployeeDictionaryRepository;
import com.github.matjanko.teksystem.dictonaries.model.project.ProjectDictionary;
import com.github.matjanko.teksystem.dictonaries.model.project.ProjectDictionaryRepository;
import com.github.matjanko.teksystem.dictonaries.model.projectstage.ProjectStageDictionaryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dictionaries")
@Api(tags = "Dictionaries")
@RequiredArgsConstructor
public class DictionaryController {

    private final ProjectStageDictionaryRepository projectStageDictionaryRepository;
    private final CustomerDictionaryRepository customerDictionaryRepository;
    private final ProjectDictionaryRepository projectDictionaryRepository;
    private final EmployeeDictionaryRepository employeeDictionaryRepository;
    private final ActivityCategoryDictionaryRepository activityCategoryDictionaryRepository;
    private final ActivitySubcategoryDictionaryRepository activitySubcategoryDictionaryRepository;
    private final ModelMapper mapper;

    @GetMapping("/project-stages")
    @ApiOperation(value = "Get project stage dictionary")
    public ResponseEntity<List<DictionaryDto>> getProjectStageDictionary() {
        List<DictionaryDto> dict = projectStageDictionaryRepository
                .findAll()
                .stream()
                .map(ps -> mapper.map(ps, DictionaryDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(dict, HttpStatus.OK);
    }

    @GetMapping("/customers")
    @ApiOperation(value = "Get customer dictionary")
    public ResponseEntity<List<DictionaryDto>> getCustomerDictionary() {
        List<DictionaryDto> dict = customerDictionaryRepository
                .findAll()
                .stream()
                .map(ps -> mapper.map(ps, DictionaryDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(dict, HttpStatus.OK);
    }

    @GetMapping("/customers/names")
    @ApiOperation(value = "Get customer names dictionary")
    public ResponseEntity<List<String>> getCustomerNamesDictionary() {
        List<String> dict = customerDictionaryRepository
                .findAll()
                .stream()
                .map(Dictionary::getName)
                .collect(Collectors.toList());

        return new ResponseEntity<>(dict, HttpStatus.OK);
    }

    @GetMapping("/projects")
    @ApiOperation(value = "Get projects dictionary")
    public ResponseEntity<List<ProjectDictionaryDto>> getProjectsDictionary() {
        List<ProjectDictionaryDto> dict = projectDictionaryRepository
                .findAll()
                .stream()
                .map(p -> mapper.map(p, ProjectDictionaryDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(dict, HttpStatus.OK);
    }

    @GetMapping("/projects/indexes")
    @ApiOperation(value = "Get project indexes dictionary")
    public ResponseEntity<List<String>> getProjectIndexesDictionary() {
        List<String> dict = projectDictionaryRepository
                .findAll()
                .stream()
                .map(ProjectDictionary::getIndex)
                .collect(Collectors.toList());

        return new ResponseEntity<>(dict, HttpStatus.OK);
    }

    @GetMapping("/employees")
    @ApiOperation(value = "Get employee dictionary")
    public ResponseEntity<List<DictionaryDto>> getEmployeeDictionary() {
        List<DictionaryDto> dict = employeeDictionaryRepository
                .findAll()
                .stream()
                .map(ps -> mapper.map(ps, DictionaryDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(dict, HttpStatus.OK);
    }

    @GetMapping("/activity/categories")
    @ApiOperation(value = "Get activity categories dictionary")
    public ResponseEntity<List<DictionaryDto>> getActivityCategoriesDictionary() {
        List<DictionaryDto> dict = activityCategoryDictionaryRepository
                .findAll()
                .stream()
                .map(ps -> mapper.map(ps, DictionaryDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(dict, HttpStatus.OK);
    }

    @GetMapping("/activity/subcategories/category/{id}")
    @ApiOperation(value = "Get activity subcategories dictionary")
    public ResponseEntity<List<DictionaryDto>> getActivitySubcategoriesDictionary(@PathVariable Long id) {
        List<DictionaryDto> dict = activitySubcategoryDictionaryRepository
                .findAllByCategoryId(id)
                .stream()
                .map(ps -> mapper.map(ps, DictionaryDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(dict, HttpStatus.OK);
    }
}
