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
    @DisplayName("Test get and set companies")
    void testGetAndSetCompanies() {
        // Arrange
        Customer customer = new Customer();
        Set<Company> expectedCompanies = new HashSet<>();

        // Act
        customer.setCompanies(expectedCompanies);

        // Assert
        assertSame(expectedCompanies, customer.getCompanies());
    }

    @Test
    @DisplayName("Test get and set customer ID")
    void testGetAndSetCustomerId() {
        // Arrange
        Customer customer = new Customer();
        UUID expectedCustomerId = UUID.randomUUID();

        // Act
        customer.setCustomerId(expectedCustomerId);

        // Assert
        assertSame(expectedCustomerId, customer.getCustomerId());
    }

    @Test
    @DisplayName("Test get and set customer shipments")
    void testGetAndSetCustomerShipments() {
        // Arrange
        Customer customer = new Customer();
        Set<Shipment> expectedShipments = new HashSet<>();

        // Act
        customer.setCustomer_shipments(expectedShipments);

        // Assert
        assertSame(expectedShipments, customer.getCustomer_shipments());
    }

    @Test
    @DisplayName("Test get and set customer name")
    void testGetAndSetName() {
        // Arrange
        Customer customer = new Customer();
        String expectedName = "Pesho";

        // Act
        customer.setName(expectedName);

        // Assert
        assertEquals(expectedName, customer.getName());
    }
}


