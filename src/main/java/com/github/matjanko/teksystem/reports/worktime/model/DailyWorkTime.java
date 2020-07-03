package com.github.matjanko.teksystem.reports.worktime.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_REPORTS_DAILY_WORK_TIME")
@Getter @Setter
public class DailyWorkTime {

    @Id
    private Long id;

    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "DATE_OF_WORK")
    private String date;

    @Column(name = "YEAR")
    private String year;

    @Column(name = "MONTH")
    private String month;

    @Column(name = "TOTAL_TIME")
    private String hours;

}
