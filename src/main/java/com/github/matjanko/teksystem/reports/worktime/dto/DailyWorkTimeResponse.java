package com.github.matjanko.teksystem.reports.worktime.dto;

import lombok.Data;

@Data
public class DailyWorkTimeResponse {

    private String date;
    private String hours;
}
