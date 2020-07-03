package com.github.matjanko.teksystem.reports.worktime.dto;

import lombok.Data;


@Data
public class MonthlyWorkTimeResponse {

    private Long employeeId;
    private String employeeName;
    private String hours;
}
