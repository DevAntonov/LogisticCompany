package com.example.logisticcompany.service;

import com.example.logisticcompany.model.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface CompanyService {
    public Iterable<Company> findAll();

    public Optional<Company> findById(UUID id);

    public Company save(Company entity);

    public Iterable<Company> saveAll(Iterable<Company> items);

    public void delete(Company entity);

    public void deleteById(UUID id);

    public Company assignCustomerToCompany(UUID companyId, UUID customerId) throws Exception;

    // add an existing office entity to the company
    public Company assignOfficeToCompany(UUID companyId, UUID officeId) throws Exception;

    public Company addShipment(UUID companyId, UUID senderId, UUID receiverId, Shipment shipment) throws Exception;

    public Shipment getShipmentInfo(UUID companyId, UUID shipmentId) throws Exception;

    public Set<Office> getCompanyOffices(UUID companyId) throws Exception;

    public void calculatePrice(Shipment shipment);

    public Company assignEmployeeToCompany(UUID companyId, UUID employeeId);

    public Set<Employee> getCompanyEmployees(UUID companyId);

    public Set<Customer> getCompanyCustomers(UUID companyId);

}
