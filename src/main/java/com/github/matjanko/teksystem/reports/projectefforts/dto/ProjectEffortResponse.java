package com.github.matjanko.teksystem.reports.projectefforts.dto;

import lombok.Data;

@Data
public class ProjectEffortResponse {

    private Long projectId;
    private String projectSymbol;
    private String projectName;
    private String customerName;
    private Long hours;
    private Boolean hasProgress;

}
