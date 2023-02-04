package com.example.logisticcompany.service;

import com.example.logisticcompany.model.Company;
import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.repository.CompanyRepository;
import com.example.logisticcompany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Iterable<Customer> saveAll(Iterable<Customer> items) {
        return customerRepository.saveAll(items);
    }

    @Override
    public void delete(Customer entity)  {
        customerRepository.delete(entity);
    }

    @Override
    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }
}
