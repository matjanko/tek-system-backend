package com.github.matjanko.teksystem.contracts.dto.project;

import com.github.matjanko.teksystem.contracts.dto.customer.CustomerResponse;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ProjectResponse {

    private Long id;
    private String name;
    private Character symbol;
    private Long number;
    private CustomerResponse customer;

    public String getIndex() {
        return symbol.toString() +
                StringUtils.leftPad(number.toString(), 4, "0") ;
    }

}
