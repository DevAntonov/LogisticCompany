package com.example.logisticcompany.service;

import com.example.logisticcompany.model.Company;
import com.example.logisticcompany.model.CompanyOffice;
import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.model.Shipment;
import com.example.logisticcompany.repository.CompanyOfficeRepository;
import com.example.logisticcompany.repository.CompanyRepository;
import com.example.logisticcompany.repository.CustomerRepository;
import com.example.logisticcompany.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private CompanyOfficeRepository companyOfficeRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, CustomerRepository customerRepository){
        this.companyRepository=companyRepository;
        this.customerRepository=customerRepository;
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
    public Company save(Company entity) {
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
    public Company assignCustomerToCompany(UUID companyId, UUID customerId) throws Exception{
        Company company = companyRepository.findById(companyId).get();
        Customer customer = customerRepository.findById(customerId).get();
        Set<Customer> customerSet = null;
        customerSet = company.getCustomerList();
        customerSet.add(customer);
        company.setCustomerList(customerSet);
        return companyRepository.save(company);
    }

    @Override
    public Company addShipment(UUID companyId, UUID senderId, UUID receiverId, Shipment shipment) throws Exception {
        Company company = companyRepository.findById(companyId).get();
        Customer sender = customerRepository.findById(senderId).get();
        Customer receiver = customerRepository.findById(receiverId).get();

        if(company.getAllShipments().contains(shipment)){
            throw new Exception("The provided shipment already exists in the system!");
        }
        // iskam tuk da setna Sender i Receiver na shipmenta!
        // нас не ни интересува в класа Customer, дали е сендър или ресийвър;
        //тази информация ни е важна само в контекста на шипмента

        shipment.setSender(sender);
        shipment.setReceiver(receiver);
        shipment.setCompany(company);
        shipmentRepository.save(shipment);

        sender.getCustomer_shipments().add(shipment);
        //sender.getCompanies().add(company);

        //receiver.getCompanies().add(company);
        receiver.getCustomer_shipments().add(shipment);
        customerRepository.save(sender);
        customerRepository.save(receiver);

        company.getCustomerList().add(sender);
        company.getCustomerList().add(receiver);
        company.getAllShipments().add(shipment);
        return companyRepository.save(company);
    }

    @Override
    public Shipment getShipmentInfo(UUID companyId, UUID shipmentId) throws Exception {
        Company company = companyRepository.findById(companyId).get();
        Shipment shipment = shipmentRepository.findById(shipmentId).get();
        if(!company.getAllShipments().contains(shipment)){
            throw new Exception("The company does not have the given shipment!");
        }

        return shipment;
    }

    @Override
    public void addCompanyOffice(UUID companyId, CompanyOffice companyOffice) throws Exception {
        Company company = companyRepository.findById(companyId).get();
        company.getOffices().add(companyOffice);
        companyOffice.setCompany(company);
        companyRepository.save(company);
        companyOfficeRepository.save(companyOffice);
    }

    @Override
    public Set<CompanyOffice> getCompanyOffices(UUID companyId) throws Exception {
        Company company = companyRepository.findById(companyId).get();
        return company.getOffices();
    }
}
