package com.github.matjanko.teksystem.contracts.api;

import com.github.matjanko.teksystem.contracts.dto.customer.CustomerRequest;
import com.github.matjanko.teksystem.contracts.dto.customer.CustomerResponse;
import com.github.matjanko.teksystem.contracts.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Api(tags = "Customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @ApiOperation(value = "Get all customers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get customer by id")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        try {
            CustomerResponse response = customerService.get(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @ApiOperation(value = "Add customer")
    public ResponseEntity<?> postCustomer(@RequestBody CustomerRequest customer) {
        try {
            Long customerId = customerService.add(customer);
            return new ResponseEntity<>(customerId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("{id}")
    @ApiOperation(value = "Edit customer")
    public ResponseEntity<?> putCustomer(@PathVariable Long id, @RequestBody CustomerRequest customer) {
        try {
            customerService.edit(id, customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete customer")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
