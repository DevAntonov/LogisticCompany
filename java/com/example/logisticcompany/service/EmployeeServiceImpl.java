package com.example.logisticcompany.service;

import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.model.Employee;
import com.example.logisticcompany.repository.CustomerRepository;
import com.example.logisticcompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }


    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public Iterable<Employee> saveAll(Iterable<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public void delete(Employee entity)  {
        employeeRepository.delete(entity);
    }

    @Override
    public void deleteById(UUID id) {
        employeeRepository.deleteById(id);
    }
}
