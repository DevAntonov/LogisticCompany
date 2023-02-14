package com.example.logisticcompany.controller;

import com.example.logisticcompany.model.Company;
import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/customer")
@RestController
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<Customer> getCustomers() { return customerService.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) { customerService.save(customer)  ; }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Customer> getCustomerById(@PathVariable UUID customerId) { return customerService.findById(customerId); }

}
