package com.github.matjanko.teksystem.contracts.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRequest {
    @NotBlank
    private String name;
}
