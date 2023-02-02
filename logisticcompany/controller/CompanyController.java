package com.example.logisticcompany.controller;

import com.example.logisticcompany.model.Company;
import com.example.logisticcompany.model.CompanyOffice;
import com.example.logisticcompany.model.Shipment;
import com.example.logisticcompany.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

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

    @GetMapping("/{companyId}")
    public void getCompanyById(@PathVariable UUID companyId) { companyService.findById(companyId);}

    @DeleteMapping("/{companyId}")
    public void deleteCompanyById(@PathVariable UUID companyId) { companyService.deleteById(companyId);}

    @DeleteMapping("/{company}")
    public void deleteCompany(@PathVariable Company company) { companyService.delete(company);}

    //This method just "registers" a customer to the given company
    @PutMapping("/{companyId}/customer/{customerId}")
    public Company assignCustomerToCompany(@PathVariable UUID companyId, @PathVariable UUID customerId) throws Exception{
        return companyService.assignCustomerToCompany(companyId, customerId);
    }

    //This method will register the provided customers to the company as well as adding the shipment
    @PutMapping("/{companyId}/sender/{senderId}/receiver/{receiverId}")
    public Company addShipment(@PathVariable UUID companyId, @PathVariable UUID senderId, @PathVariable UUID receiverId, @RequestBody Shipment shipment) throws Exception{
        return companyService.addShipment(companyId, senderId, receiverId, shipment);
    }

    @PutMapping("/{companyId}/companyOffice")
    public void addCompanyOffice(@PathVariable UUID companyId, @RequestBody CompanyOffice companyOffice) throws Exception{
        companyService.addCompanyOffice(companyId, companyOffice);
    }

    @GetMapping("/{companyId}/companyOffice")
    public Set<CompanyOffice> getCompanyOffices(@PathVariable UUID companyId) throws Exception{
        return companyService.getCompanyOffices(companyId);
    }

    @GetMapping("/{companyId}/shipment/{shipmentId}")
    public Shipment getShipmentInfo(@PathVariable UUID companyId, @PathVariable UUID shipmentId) throws Exception { return companyService.getShipmentInfo(companyId, shipmentId);}

}

