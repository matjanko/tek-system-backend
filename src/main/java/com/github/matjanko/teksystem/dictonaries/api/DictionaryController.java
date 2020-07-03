package com.github.matjanko.teksystem.dictonaries.api;

import com.github.matjanko.teksystem.dictonaries.dto.DictionaryDto;
import com.github.matjanko.teksystem.dictonaries.model.Dictionary;
import com.github.matjanko.teksystem.dictonaries.model.customer.CustomerDictionaryRepository;
import com.github.matjanko.teksystem.dictonaries.model.projectstage.ProjectStageDictionaryRepository;
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
@RequestMapping("/api/dictionaries")
@Api(tags = "Dictionaries")
@RequiredArgsConstructor
public class DictionaryController {

    private final ProjectStageDictionaryRepository projectStageDictionaryRepository;
    private final CustomerDictionaryRepository customerDictionaryRepository;
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
}
