package com.github.matjanko.teksystem.contracts.dto;

import lombok.Data;

@Data
public class ProjectDto {

    private Long id;
    private String name;
    private Character symbol;
    private Long number;
    private CustomerDto customer;

}
