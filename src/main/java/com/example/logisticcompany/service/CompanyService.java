package com.example.logisticcompany.service;

import com.example.logisticcompany.exceptions.*;
import com.example.logisticcompany.model.Company;
import com.example.logisticcompany.model.Employee;
import com.example.logisticcompany.model.Office;
import com.example.logisticcompany.model.Shipment;
import com.example.logisticcompany.model.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface CompanyService {
    public Iterable<Company> findAll();

    public Optional<Company> findById(UUID id);

    public Company save(Company entity) throws CompanyWithThatNameAlreadyExistsException;

    public Iterable<Company> saveAll(Iterable<Company> items);

    public void delete(Company entity);

    public void deleteById(UUID id);

    public Company assignCustomerToCompany(UUID companyId, UUID customerId) throws CustomerAlreadyExistsInCompanyException;

    // add an existing office entity to the company
    public Company assignOfficeToCompany(UUID companyId, UUID officeId) throws OfficeAlreadyAssignedToCompanyException;

    public Company addShipment(UUID companyId, UUID senderId, UUID receiverId, Shipment shipment) throws ShipmentAlreadyRegisteredException;

    public Shipment getShipmentInfo(UUID companyId, UUID shipmentId) throws ShipmentNotFoundException;

    public Set<Office> getCompanyOffices(UUID companyId) throws Exception;

    public void calculatePrice(Shipment shipment);

    public Company assignEmployeeToCompany(UUID companyId, UUID employeeId) throws EmployeeAlreadyAssignedToCompanyException;

    public Set<Employee> getCompanyEmployees(UUID companyId);

    public Set<Customer> getCompanyCustomers(UUID companyId);
}
