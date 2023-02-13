package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class ShipmentTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Shipment}
     *   <li>{@link Shipment#setAddressTo(String)}
     *   <li>{@link Shipment#setCompany(Company)}
     *   <li>{@link Shipment#setOfficeFrom(Office)}
     *   <li>{@link Shipment#setOfficeTo(Office)}
     *   <li>{@link Shipment#setPrice(Double)}
     *   <li>{@link Shipment#setReceiver(Customer)}
     *   <li>{@link Shipment#setSender(Customer)}
     *   <li>{@link Shipment#setShipmentId(UUID)}
     *   <li>{@link Shipment#setWeight(Double)}
     *   <li>{@link Shipment#getAddressTo()}
     *   <li>{@link Shipment#getCompany()}
     *   <li>{@link Shipment#getOfficeFrom()}
     *   <li>{@link Shipment#getOfficeTo()}
     *   <li>{@link Shipment#getPrice()}
     *   <li>{@link Shipment#getReceiver()}
     *   <li>{@link Shipment#getSender()}
     *   <li>{@link Shipment#getShipmentId()}
     *   <li>{@link Shipment#getWeight()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Shipment actualShipment = new Shipment();
        actualShipment.setAddressTo("ulica 1");
        Company company = new Company();
        company.setAllShipments(new HashSet<>());
        company.setCompanyId(UUID.randomUUID());
        company.setCompanyName("kompaniq");
        company.setCustomerList(new HashSet<>());
        company.setEmployees(new HashSet<>());
        company.setOffices(new HashSet<>());
        actualShipment.setCompany(company);
        Company company1 = new Company();
        company1.setAllShipments(new HashSet<>());
        company1.setCompanyId(UUID.randomUUID());
        company1.setCompanyName("kompaniq");
        company1.setCustomerList(new HashSet<>());
        company1.setEmployees(new HashSet<>());
        company1.setOffices(new HashSet<>());
        Office office = new Office();
        office.setCompany(company1);
        office.setCompanyOfficeId(UUID.randomUUID());
        office.setOfficeAddress("ulica 1");
        office.setShipments(new HashSet<>());
        actualShipment.setOfficeFrom(office);
        Company company2 = new Company();
        company2.setAllShipments(new HashSet<>());
        company2.setCompanyId(UUID.randomUUID());
        company2.setCompanyName("kompaniq");
        company2.setCustomerList(new HashSet<>());
        company2.setEmployees(new HashSet<>());
        company2.setOffices(new HashSet<>());
        Office office1 = new Office();
        office1.setCompany(company2);
        office1.setCompanyOfficeId(UUID.randomUUID());
        office1.setOfficeAddress("ulica 1");
        office1.setShipments(new HashSet<>());
        actualShipment.setOfficeTo(office1);
        actualShipment.setPrice(10.0d);
        Customer customer = new Customer();
        customer.setCompanies(new HashSet<>());
        customer.setCustomerId(UUID.randomUUID());
        customer.setCustomer_shipments(new HashSet<>());
        customer.setName("ime");
        actualShipment.setReceiver(customer);
        Customer customer1 = new Customer();
        customer1.setCompanies(new HashSet<>());
        customer1.setCustomerId(UUID.randomUUID());
        customer1.setCustomer_shipments(new HashSet<>());
        customer1.setName("ime");
        actualShipment.setSender(customer1);
        UUID randomUUIDResult = UUID.randomUUID();
        actualShipment.setShipmentId(randomUUIDResult);
        actualShipment.setWeight(10.0d);
        assertEquals("ulica 1", actualShipment.getAddressTo());
        assertSame(company, actualShipment.getCompany());
        assertSame(office, actualShipment.getOfficeFrom());
        assertSame(office1, actualShipment.getOfficeTo());
        assertEquals(10.0d, actualShipment.getPrice().doubleValue());
        assertSame(customer, actualShipment.getReceiver());
        assertSame(customer1, actualShipment.getSender());
        assertSame(randomUUIDResult, actualShipment.getShipmentId());
        assertEquals(10.0d, actualShipment.getWeight().doubleValue());
    }
}

