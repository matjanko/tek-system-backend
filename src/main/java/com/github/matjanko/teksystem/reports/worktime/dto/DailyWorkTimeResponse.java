package com.github.matjanko.teksystem.reports.worktime.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@Data
public class DailyWorkTimeResponse {

    private String date;

    private String hours;

    public String getWeekDay() {
        return LocalDate
                .parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pl"));
    }
}
