package com.github.matjanko.teksystem.reports.projectefforts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_REPORTS_PROJECT_EFFORT")
@Getter @Setter
public class ProjectEffort {

    @Id
    private Long id;

    @Column(name ="PROJECT_ID")
    private Long projectId;

    @Column(name ="PROJECT_SYMBOL")
    private String projectSymbol;

    @Column(name ="PROJECT_NAME")
    private String projectName;

    @Column(name ="CUSTOMER_NAME")
    private String customerName;

    @Column(name ="HOURS")
    private Long hours;

    @Column(name ="HAS_PROGRESS")
    private Boolean hasProgress;

}
