package com.github.matjanko.teksystem.reports.tasks.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "V_REPORTS_EMPLOYEE_TASK")
@Getter
public class EmployeeTask {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "PROJECT_NUMBER")
    private String projectNumber;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "PROJECT_STAGE_NAME")
    private String projectStageName;

    @Column(name = "FIRST_ACTIVITY")
    private String firstActivity;

    @Column(name = "SECOND_ACTIVITY")
    private String secondActivity;

    @Column(name = "THIRD_ACTIVITY")
    private String thirdActivity;

    @Column(name = "SOFTWARE")
    private String software;

    @Column(name = "ADDITIONAL_COST")
    private boolean isAdditionalCost;

    @Column(name = "MISTAKE")
    private boolean isMistake;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "END_TIME")
    private LocalDateTime endTime;

    @Column(name = "HOURS")
    private BigDecimal hours;
}
