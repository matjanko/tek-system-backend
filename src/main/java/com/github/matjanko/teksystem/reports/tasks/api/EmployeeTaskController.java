package com.github.matjanko.teksystem.reports.tasks.api;

import com.github.matjanko.teksystem.reports.tasks.dto.EmployeeTaskResponse;
import com.github.matjanko.teksystem.reports.tasks.model.EmployeeTask;
import com.github.matjanko.teksystem.reports.tasks.model.EmployeeTaskRepository;
import com.github.matjanko.teksystem.reports.tasks.model.spec.EmployeeTaskWithCustomerName;
import com.github.matjanko.teksystem.reports.tasks.model.spec.EmployeeTaskWithEmployeeName;
import com.github.matjanko.teksystem.reports.tasks.model.spec.EmployeeTaskWithProjectName;
import com.github.matjanko.teksystem.reports.tasks.model.spec.EmployeeTaskWithProjectNumber;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports/tasks")
@Api(tags = "Employee tasks")
@RequiredArgsConstructor
public class EmployeeTaskController {

    private final EmployeeTaskRepository employeeTaskRepository;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmployeeTaskResponse>> getEmployeeTasks(
            @RequestParam(value = "employeeName", required = false) String employeeName,
            @RequestParam(value = "projectNumber", required = false) String projectNumber,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "projectName", required = false) String projectName,
            @RequestParam(value = "projectStageName", required = false) String projectStageName,
            @RequestParam(value = "firstActivity", required = false) String firstActivity,
            @RequestParam(value = "secondActivity", required = false) String secondActivity,
            @RequestParam(value = "thirdActivity", required = false) String thirdActivity,
            @RequestParam(value = "software", required = false) String software,
            @RequestParam(value = "isAddCost", required = false) boolean isAddCost,
            @RequestParam(value = "isMistake", required = false) boolean isMistake,
            @RequestParam(value = "startTime", required = false) LocalDateTime startTime,
            @RequestParam(value = "endTime", required = false) LocalDateTime endTime) {

        Specification<EmployeeTask> specification = Specification
                .where(new EmployeeTaskWithEmployeeName(employeeName))
                .and(new EmployeeTaskWithProjectNumber(projectNumber))
                .and(new EmployeeTaskWithCustomerName(customerName))
                .and(new EmployeeTaskWithProjectName(projectName));

        List<EmployeeTaskResponse> tasks = employeeTaskRepository
                .findAll(specification)
                .stream()
                .map(et -> mapper.map(et, EmployeeTaskResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

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
