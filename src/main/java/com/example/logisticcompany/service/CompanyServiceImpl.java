package com.example.logisticcompany.service;

import com.example.logisticcompany.exceptions.*;
import com.example.logisticcompany.model.*;
import com.example.logisticcompany.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private OfficeRepository officeRepository;
    private final EmployeeRepository employeeRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, CustomerRepository customerRepository,
                              EmployeeRepository employeeRepository){
        this.companyRepository=companyRepository;
        this.customerRepository=customerRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(UUID id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company entity) throws CompanyWithThatNameAlreadyExistsException {
        List<Company> companies = companyRepository.findAll();

        if (companies.size() > 0) {
            for (Company company : companies) {
                if (company.getCompanyName().equals(entity.getCompanyName())) {
                    throw new CompanyWithThatNameAlreadyExistsException("Company with that name already exists!");
                }
            }
        }

        return companyRepository.save(entity);
    }

    @Override
    public Iterable<Company> saveAll(Iterable<Company> items) {
        return companyRepository.saveAll(items);
    }

    @Override
    public void delete(Company entity)  {
        companyRepository.delete(entity);
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company assignCustomerToCompany(UUID companyId, UUID customerId) throws CustomerAlreadyExistsInCompanyException {
        Company company = companyRepository.findById(companyId).get();
        Customer customer = customerRepository.findById(customerId).get();

        if (company.getCustomerList().contains(customer)) {
            throw new CustomerAlreadyExistsInCompanyException("This customer is already registered in the system!");
        }

        customer.getCompanies().add(company);
        company.getCustomerList().add(customer);
        return companyRepository.save(company);
    }

    @Override
    public Company assignOfficeToCompany(UUID companyId, UUID officeId) throws OfficeAlreadyAssignedToCompanyException {
        Company company = companyRepository.findById(companyId).get();
        Office office = officeRepository.findById(officeId).get();

        if (company.getOffices().contains(office)) {
            throw new OfficeAlreadyAssignedToCompanyException("This office is already assigned to this company!");
        }

        office.setCompany(company);
        company.getOffices().add(office);
        return companyRepository.save(company);
    }

    @Override
    public Company addShipment(UUID companyId, UUID senderId, UUID receiverId, Shipment shipment) throws ShipmentAlreadyRegisteredException {
        Company company = companyRepository.findById(companyId).get();
        Customer sender = customerRepository.findById(senderId).get();
        Customer receiver = customerRepository.findById(receiverId).get();

        if (company.getAllShipments().contains(shipment)) {
            throw new ShipmentAlreadyRegisteredException("The provided shipment already exists in the system!");
        }

        shipment.setSender(sender);
        shipment.setReceiver(receiver);
        shipment.setCompany(company);
        shipment.getOfficeFrom().getShipments().add(shipment);
        shipment.getOfficeFrom().setCompany(company);
        shipment.getOfficeTo().setCompany(company);
        shipment.getOfficeTo().getShipments().add(shipment);

        calculatePrice(shipment);
        shipmentRepository.save(shipment);

        sender.getCustomer_shipments().add(shipment);
        receiver.getCustomer_shipments().add(shipment);
        customerRepository.save(sender);
        customerRepository.save(receiver);

        company.getOffices().add(shipment.getOfficeTo());
        company.getOffices().add(shipment.getOfficeFrom());
        company.getCustomerList().add(sender);
        company.getCustomerList().add(receiver);
        company.getAllShipments().add(shipment);
        return companyRepository.save(company);
    }

    @Override
    public Shipment getShipmentInfo(UUID companyId, UUID shipmentId) throws ShipmentNotFoundException {
        Company company = companyRepository.findById(companyId).get();
        Shipment shipment = shipmentRepository.findById(shipmentId).get();

        if (!company.getAllShipments().contains(shipment)){
            throw new ShipmentNotFoundException("The company does not have the given shipment!");
        }

        return shipment;
    }

    @Override
    public Set<Office> getCompanyOffices(UUID companyId) throws Exception {
        Company company = companyRepository.findById(companyId).get();
        return company.getOffices();
    }

    @Override
    public void calculatePrice(Shipment shipment) {
        Double HIGH_PRICE = 20.0;
        Double LOW_PRICE = 10.0;

        if(shipment.getOfficeTo() == null || shipment.getAddressTo() != null){
            // ???????????? ???????????? ?????? ?????????? ?????????????? ?????????? ?????????? ???? ????????????????(??????????????????) -> ?????????????? ???????????? ??????????
            shipment.setPrice(HIGH_PRICE*shipment.getWeight());
        }else {
            shipment.setPrice(LOW_PRICE * shipment.getWeight());
        }
        shipmentRepository.save(shipment);
    }

    @Override
    public Company assignEmployeeToCompany(UUID companyId, UUID employeeId) throws EmployeeAlreadyAssignedToCompanyException {
        Company company = companyRepository.findById(companyId).get();
        Employee employee = employeeRepository.findById(employeeId).get();

        if (company.getEmployees().contains(employee)) {
            throw new EmployeeAlreadyAssignedToCompanyException("This employee is already assigned to the company!");
        }

        employee.setCompany(company);
        company.getEmployees().add(employee);
        return companyRepository.save(company);
    }

    @Override
    public Set<Employee> getCompanyEmployees(UUID companyId) {
        return getCompanyEmployees(companyId);
    }

    @Override
    public Set<Customer> getCompanyCustomers(UUID companyId) {
        Set<Customer> customers = new HashSet<>();

        List<Customer> allCustomers = customerRepository.findAll();

        for (Customer customer : allCustomers) {
            Set<Company> customerCompanies = customer.getCompanies();
            for (Company company : customerCompanies) {
                if (company.getCompanyId().equals(companyId)) {
                    customers.add(customer);
                }
            }
        }

        return customers;
    }
}
