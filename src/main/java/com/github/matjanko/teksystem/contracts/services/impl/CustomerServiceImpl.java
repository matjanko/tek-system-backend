package com.github.matjanko.teksystem.contracts.services.impl;

import com.github.matjanko.teksystem.contracts.dto.CustomerDto;
import com.github.matjanko.teksystem.contracts.model.customer.CustomerRepository;
import com.github.matjanko.teksystem.contracts.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream()
                .map(customer -> mapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }
}
