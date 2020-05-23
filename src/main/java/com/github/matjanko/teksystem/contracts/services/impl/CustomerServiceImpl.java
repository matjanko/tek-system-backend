package com.github.matjanko.teksystem.contracts.services.impl;

import com.github.matjanko.teksystem.base.exceptions.EntityNotFoundException;
import com.github.matjanko.teksystem.contracts.dto.customer.CustomerRequest;
import com.github.matjanko.teksystem.contracts.dto.customer.CustomerResponse;
import com.github.matjanko.teksystem.contracts.model.customer.Customer;
import com.github.matjanko.teksystem.contracts.model.customer.CustomerRepository;
import com.github.matjanko.teksystem.contracts.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<CustomerResponse> getAll() {
        return repository.findAll().stream()
                .map(c -> mapper.map(c, CustomerResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse get(Long id) {
        return repository
                .findById(id)
                .map(c -> mapper.map(c, CustomerResponse.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Long add(@NotNull CustomerRequest request) {
        Customer customer = mapper.map(request, Customer.class);
        repository.save(customer);
        return customer.getId();
    }

    @Override
    public void edit(@NotNull Long id, @NotNull CustomerRequest request) {
        repository.findById(id)
                .map(c -> {
                    repository.save(mapper.map(request, Customer.class));
                    return c;
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(@NotNull Long id) {
        repository.deleteById(id);
    }
}
