package com.github.matjanko.teksystem.reports.worktime.api;

import com.github.matjanko.teksystem.reports.worktime.dto.DailyWorkTimeResponse;
import com.github.matjanko.teksystem.reports.worktime.dto.MonthlyWorkTimeResponse;
import com.github.matjanko.teksystem.reports.worktime.model.DailyWorkTimeRepository;
import com.github.matjanko.teksystem.reports.worktime.model.MonthlyWorkTimeRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/work-time")
@Api(tags = "Work time")
@RequiredArgsConstructor
public class WorkTimeController {

    private final MonthlyWorkTimeRepository monthlyWorkTimeRepository;
    private final DailyWorkTimeRepository dailyWorkTimeRepository;
    private final ModelMapper mapper;

    @GetMapping("/monthly/all/year/{year}/month/{month}")
    public ResponseEntity<List<MonthlyWorkTimeResponse>> getMonthlyWorkTimeList(
            @PathVariable String year, @PathVariable String month) {

        List<MonthlyWorkTimeResponse> workTimes = monthlyWorkTimeRepository
                .findAllByYearAndMonth(year, month)
                .stream()
                .map(wt -> mapper.map(wt, MonthlyWorkTimeResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(workTimes, HttpStatus.OK);
    }

    @GetMapping("/daily/all/year/{year}/month/{month}/employee/{employeeId}")
    public ResponseEntity<List<DailyWorkTimeResponse>> getDailylyWorkTimeList(
            @PathVariable String year, @PathVariable String month, @PathVariable Long employeeId) {

        List<DailyWorkTimeResponse> workTimes = dailyWorkTimeRepository
                .findAllByYearAndMonthAndEmployeeId(year, month, employeeId)
                .stream()
                .map(wt -> mapper.map(wt, DailyWorkTimeResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(workTimes, HttpStatus.OK);
    }
}
