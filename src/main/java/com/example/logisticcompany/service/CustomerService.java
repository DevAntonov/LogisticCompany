package com.example.logisticcompany.service;

import com.example.logisticcompany.model.Company;
import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.repository.CompanyRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerService {


    public Iterable<Customer> findAll();

    public Optional<Customer> findById(UUID id);

    public Customer save(Customer entity);

    public Iterable<Customer> saveAll(Iterable<Customer> items);

    public void delete(Customer entity);

    public void deleteById(UUID id);


}
