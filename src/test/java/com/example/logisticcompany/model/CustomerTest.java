package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testConstructor() {
        // Arrange and Act
        Customer actualCustomer = new Customer();
        HashSet<Company> companySet = new HashSet<>();
        actualCustomer.setCompanies(companySet);
        UUID randomUUIDResult = UUID.randomUUID();
        actualCustomer.setCustomerId(randomUUIDResult);
        HashSet<Shipment> shipmentSet = new HashSet<>();
        actualCustomer.setCustomer_shipments(shipmentSet);
        actualCustomer.setName("Pesho");

        // Assert
        assertSame(companySet, actualCustomer.getCompanies());
        assertSame(randomUUIDResult, actualCustomer.getCustomerId());
        assertSame(shipmentSet, actualCustomer.getCustomer_shipments());
        assertEquals("Pesho", actualCustomer.getName());
    }
}

