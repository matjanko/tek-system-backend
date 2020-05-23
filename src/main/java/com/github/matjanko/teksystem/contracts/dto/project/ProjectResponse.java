package com.github.matjanko.teksystem.contracts.dto.project;

import com.github.matjanko.teksystem.contracts.dto.customer.CustomerResponse;
import lombok.Data;

@Data
public class ProjectResponse {

    private Long id;
    private String name;
    private Character symbol;
    private Long number;
    private CustomerResponse customer;

}
