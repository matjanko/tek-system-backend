package com.github.matjanko.teksystem.contracts.services;

import com.github.matjanko.teksystem.contracts.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<CustomerDto> getAll();

}
