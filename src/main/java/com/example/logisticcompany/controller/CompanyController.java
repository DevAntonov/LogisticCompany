package com.example.logisticcompany.controller;

import com.example.logisticcompany.model.Company;
import com.example.logisticcompany.model.Employee;
import com.example.logisticcompany.model.Office;
import com.example.logisticcompany.model.Shipment;
import com.example.logisticcompany.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.logisticcompany.model.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@CrossOrigin()
@RequestMapping("/company")
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<Company> getCompanies() { return companyService.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestBody Company company) { companyService.save(company); }

    @DeleteMapping("/{companyId}")
    public Optional<Company> getCompanyById(@PathVariable UUID companyId) { return companyService.findById(companyId);}

    @GetMapping("delete/{companyId}")
    public void deleteCompanyById(@PathVariable UUID companyId) { companyService.deleteById(companyId);}

    @DeleteMapping("/{company}")
    public void deleteCompany(@PathVariable Company company) { companyService.delete(company);}

    //This method just "registers" a customer to the given company
    @PutMapping("/{companyId}/customer/{customerId}")
    public Company assignCustomerToCompany(@PathVariable UUID companyId, @PathVariable UUID customerId) throws Exception{
        return companyService.assignCustomerToCompany(companyId, customerId);
    }

    @PutMapping("/{companyId}/office/{officeId}")
    public Company assignOfficeToCompany(@PathVariable UUID companyId, @PathVariable UUID officeId) throws Exception{
        return companyService.assignOfficeToCompany(companyId, officeId);
    }

    @GetMapping("/{companyId}/companyOffice")
    public Set<Office> getCompanyOffices(@PathVariable UUID companyId) throws Exception{
        return companyService.getCompanyOffices(companyId);
    }

    @PutMapping("/{companyId}/employee/{employeeId}")
    public Company assignEmployeeToCompany(@PathVariable UUID companyId, @PathVariable UUID employeeId) throws Exception{
        return companyService.assignEmployeeToCompany(companyId, employeeId);
    }

    @GetMapping("/{companyId}/employee")
    public Set<Employee> getCompanyEmployees(@PathVariable UUID companyId) throws Exception{
        return companyService.getCompanyEmployees(companyId);
    }

    //This method will register the provided customers to the company as well as adding the shipment
    @PutMapping("/{companyId}/sender/{senderId}/receiver/{receiverId}")
    public Company addShipment(@PathVariable UUID companyId, @PathVariable UUID senderId, @PathVariable UUID receiverId, @RequestBody Shipment shipment) throws Exception{
        return companyService.addShipment(companyId, senderId, receiverId, shipment);
    }

    @GetMapping("/{companyId}/shipment/{shipmentId}")
    public Shipment getShipmentInfo(@PathVariable UUID companyId, @PathVariable UUID shipmentId) throws Exception { return companyService.getShipmentInfo(companyId, shipmentId);}
    @GetMapping("/{companyId}/customer")
    public Set<Customer> getCompanyCustomers(@PathVariable UUID companyId) throws Exception{
        return companyService.getCompanyCustomers(companyId);
    }
}

