package com.github.matjanko.teksystem.reports.worktime.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "V_REPORTS_MONTHLY_WORK_TIME")
@Getter @Setter
public class MonthlyWorkTime {

    @Id
    private Long id;

    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "MONTH")
    private Integer month;

    @Column(name = "TOTAL_TIME")
    private Double hours;

}
