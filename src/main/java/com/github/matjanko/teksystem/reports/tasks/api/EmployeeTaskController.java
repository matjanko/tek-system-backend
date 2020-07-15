package com.github.matjanko.teksystem.reports.tasks.api;

import com.github.matjanko.teksystem.reports.tasks.dto.EmployeeTaskResponse;
import com.github.matjanko.teksystem.reports.tasks.model.EmployeeTaskRepository;
import com.github.matjanko.teksystem.reports.worktime.dto.MonthlyWorkTimeResponse;
import io.swagger.annotations.Api;
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
@RequestMapping("/api/reports/tasks")
@Api(tags = "Employee tasks")
@RequiredArgsConstructor
public class EmployeeTaskController {

    private final EmployeeTaskRepository employeeTaskRepository;
    private final ModelMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeTaskResponse>> getAllEmployeeTasks() {

        List<EmployeeTaskResponse> tasks = employeeTaskRepository
                .findAll()
                .stream()
                .map(et -> mapper.map(et, EmployeeTaskResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
