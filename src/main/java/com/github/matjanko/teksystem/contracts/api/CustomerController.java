package com.github.matjanko.teksystem.contracts.api;

import com.github.matjanko.teksystem.base.exceptions.EntityAlreadyExistsException;
import com.github.matjanko.teksystem.base.exceptions.EntityNotFoundException;
import com.github.matjanko.teksystem.contracts.dto.CustomerRequest;
import com.github.matjanko.teksystem.contracts.dto.CustomerResponse;
import com.github.matjanko.teksystem.contracts.model.customer.Customer;
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
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> customers = customerRepository
                .findAll()
                .stream()
                .map(c -> mapper.map(c, CustomerResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get customer by id")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id) {
        CustomerResponse customer = customerRepository
                .findById(id)
                .map(c -> mapper.map(c, CustomerResponse.class))
                .orElseThrow(EntityNotFoundException::new);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Add customer")
    public ResponseEntity<Long> postCustomer(@RequestBody CustomerRequest request) {
        if (customerRepository.existsByName(request.getName())) {
            throw new EntityAlreadyExistsException();
        }
        Customer customer = customerRepository.save(mapper.map(request, Customer.class));
        return new ResponseEntity<>(customer.getId(), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Edit customer")
    public ResponseEntity<?> putCustomer(@PathVariable Long id, @RequestBody CustomerRequest request) {
        if (customerRepository.existsByName(request.getName())) {
            throw new EntityAlreadyExistsException();
        }
        return customerRepository
                .findById(id)
                .map(c -> {
                    c.setName(request.getName());
                    customerRepository.save(c);
                    return new ResponseEntity<>(HttpStatus.OK);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete customer")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
