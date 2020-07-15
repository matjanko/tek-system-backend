package com.github.matjanko.teksystem.reports.tasks.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeTaskResponse {

    private Long id;
    private String employeeName;
    private String projectNumber;
    private String customerName;
    private String projectName;
    private String projectStageName;
    private String firstActivity;
    private String secondActivity;
    private String thirdActivity;
    private String software;
    private boolean isAdditionalCost;
    private boolean isMistake;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal hours;

}
