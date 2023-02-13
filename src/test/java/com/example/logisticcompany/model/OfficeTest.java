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
        UUID companyId = UUID.randomUUID();
        Company company = new Company();
        company.setCompanyId(companyId);
        company.setCompanyName("kompaniq");
        company.setAllShipments(new HashSet<>());
        company.setCustomerList(new HashSet<>());
        company.setEmployees(new HashSet<>());
        company.setOffices(new HashSet<>());

        UUID officeId = UUID.randomUUID();
        String officeAddress = "ulica 1";
        Set<Shipment> shipments = new HashSet<>();

        // Act
        Office actualOffice = new Office();
        actualOffice.setCompany(company);
        actualOffice.setCompanyOfficeId(officeId);
        actualOffice.setOfficeAddress(officeAddress);
        actualOffice.setShipments(shipments);

        // Assert
        assertSame(company, actualOffice.getCompany());
        assertSame(officeId, actualOffice.getCompanyOfficeId());
        assertEquals(officeAddress, actualOffice.getOfficeAddress());
        assertSame(shipments, actualOffice.getShipments());
    }
}

