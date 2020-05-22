package com.github.matjanko.teksystem.contracts.api;

import com.github.matjanko.teksystem.contracts.dto.CustomerDto;
import com.github.matjanko.teksystem.contracts.model.customer.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
@Api(tags = "Customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @GetMapping
    @ApiOperation(value = "Get all customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerRepository.findAll().stream()
                .map(c -> mapper.map(c, CustomerDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get customer by id")
    public ResponseEntity<CustomerDto> getCustomers(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    @ApiOperation(value = "Get customer by id")
    public ResponseEntity<CustomerDto> postCustomers(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
