package com.github.matjanko.teksystem.contracts.services;

import com.github.matjanko.teksystem.contracts.dto.customer.CustomerRequest;
import com.github.matjanko.teksystem.contracts.dto.customer.CustomerResponse;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface CustomerService {

    List<CustomerResponse> getAll();

    CustomerResponse get(Long id);

    Long add(@NotNull CustomerRequest request);

    void edit(@NotNull Long id, @NotNull CustomerRequest request);

    void delete(@NotNull Long id);

}
