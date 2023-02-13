package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class OfficeTest {

    @Test
    void testConstructor() {
        // Arrange
        Company company = new Company();
        company.setAllShipments(new HashSet<>());
        company.setCompanyId(UUID.randomUUID());
        company.setCompanyName("kompaniq");
        company.setCustomerList(new HashSet<>());
        company.setEmployees(new HashSet<>());
        company.setOffices(new HashSet<>());

        UUID randomUUIDResult = UUID.randomUUID();
        String officeAddress = "ulica 1";
        Set<Shipment> shipmentSet = new HashSet<>();

        // Act
        Office actualOffice = new Office();
        actualOffice.setCompany(company);
        actualOffice.setCompanyOfficeId(randomUUIDResult);
        actualOffice.setOfficeAddress(officeAddress);
        actualOffice.setShipments(shipmentSet);

        // Assert
        assertSame(company, actualOffice.getCompany());
    }

    @Test
    void testConstructor_CompanyOfficeId() {
        // Arrange
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        Office actualOffice = new Office();
        actualOffice.setCompanyOfficeId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, actualOffice.getCompanyOfficeId());
    }

    @Test
    void testConstructor_OfficeAddress() {
        // Arrange
        String officeAddress = "ulica 1";

        // Act
        Office actualOffice = new Office();
        actualOffice.setOfficeAddress(officeAddress);

        // Assert
        assertEquals(officeAddress, actualOffice.getOfficeAddress());
    }

    @Test
    void testConstructor_Shipments() {
        // Arrange
        Set<Shipment> shipmentSet = new HashSet<>();

        // Act
        Office actualOffice = new Office();
        actualOffice.setShipments(shipmentSet);

        // Assert
        assertSame(shipmentSet, actualOffice.getShipments());
    }
}

