package com.example.logisticcompany.controller;

import com.example.logisticcompany.model.Employee;
import com.example.logisticcompany.model.Office;
import com.example.logisticcompany.service.EmployeeService;
import com.example.logisticcompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<Employee> getEmployees() { return employeeService.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOffice(@RequestBody Employee employee) { employeeService.save(employee)  ; }

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Employee> getEmployeeById(@PathVariable UUID employeeId) { return employeeService.findById(employeeId); }
}
