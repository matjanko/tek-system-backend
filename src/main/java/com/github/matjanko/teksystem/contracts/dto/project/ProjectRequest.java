package com.github.matjanko.teksystem.contracts.dto.project;

import lombok.Data;

@Data
public class ProjectRequest {

    private String name;
    private Character symbol;
    private Long customerId;
}
