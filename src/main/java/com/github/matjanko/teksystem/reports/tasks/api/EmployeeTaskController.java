package com.github.matjanko.teksystem.reports.tasks.api;

import com.github.matjanko.teksystem.reports.tasks.dto.EmployeeTaskResponse;
import com.github.matjanko.teksystem.reports.tasks.model.EmployeeTask;
import com.github.matjanko.teksystem.reports.tasks.model.EmployeeTaskRepository;
import com.github.matjanko.teksystem.reports.tasks.model.spec.*;
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
            @RequestParam(value = "employeeId", required = false) Long employeeId,
            @RequestParam(value = "customerId", required = false) Long customerId,
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "projectStageId", required = false) Long projectStageId,
            @RequestParam(value = "activityCategoryId", required = false) Long activityCategoryId,
            @RequestParam(value = "secondActivity", required = false) String secondActivity,
            @RequestParam(value = "thirdActivity", required = false) String thirdActivity,
            @RequestParam(value = "software", required = false) String software,
            @RequestParam(value = "isAddCost", required = false) boolean isAddCost,
            @RequestParam(value = "isMistake", required = false) boolean isMistake,
            @RequestParam(value = "startTime", required = false) LocalDateTime startTime,
            @RequestParam(value = "endTime", required = false) LocalDateTime endTime) {

        Specification<EmployeeTask> specification = Specification
                .where(new EmployeeTaskWithEmployeeId(employeeId))
                .and(new EmployeeTaskWithProjectId(projectId))
                .and(new EmployeeTaskWithCustomerId(customerId))
                .and(new EmployeeTaskWithProjectStageId(projectStageId))
                .and(new EmployeeTaskWithFirstActivityId(activityCategoryId))
                .and(new EmployeeTaskWithSecondActivity(secondActivity))
                .and(new EmployeeTaskWithThirdActivity(thirdActivity))
                .and(new EmployeeTaskWithSoftware(software))
                .and(new EmployeeTaskWithAdditionalCost(isAddCost))
                .and(new EmployeeTaskWithMistake(isMistake))
                .and(new EmployeeTaskWithStartTime(startTime))
                .and(new EmployeeTaskWithEndTime(endTime));

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
