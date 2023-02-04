package com.example.logisticcompany.service;

import com.example.logisticcompany.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

    public Company addShipment(UUID companyId, UUID senderId, UUID receiverId, Shipment shipment) throws Exception;

    public Shipment getShipmentInfo(UUID companyId, UUID shipmentId) throws Exception;

    public void addCompanyOffice(UUID companyId, CompanyOffice companyOffice) throws Exception;

    public Set<CompanyOffice> getCompanyOffices(UUID companyId) throws Exception;

    public void addEmployee(UUID companyId, Employee employee) throws Exception;

    public Set<Employee> getCompanyEmployees(UUID companyId) throws Exception;

//    Not sure if this is the right way to do it
//    public CompanyOffice assignEmployeeToOffice(UUID companyOfficeId, UUID employeeId) throws Exception;
}
