package com.example.logisticcompany.service;

import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.model.Employee;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    public Iterable<Employee> findAll();

    public Optional<Employee> findById(UUID id);

    public Employee save(Employee entity);

    public Iterable<Employee> saveAll(Iterable<Employee> employees);

    public void delete(Employee entity);

    public void deleteById(UUID id);
}
