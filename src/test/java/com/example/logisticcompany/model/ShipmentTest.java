package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShipmentTest {

    @Test
    @DisplayName("Test setAddressTo")
    void testAddressTo() {
        // Arrange
        Shipment actualShipment = new Shipment();
        String expectedAddressTo = "ulica 1";

        // Act
        actualShipment.setAddressTo(expectedAddressTo);

        // Assert
        assertEquals(expectedAddressTo, actualShipment.getAddressTo());
    }

    @Test
    @DisplayName("Test setCompany")
    void testCompany() {
        // Arrange
        Shipment actualShipment = new Shipment();
        Company expectedCompany = new Company();

        // Act
        actualShipment.setCompany(expectedCompany);

        // Assert
        assertSame(expectedCompany, actualShipment.getCompany());
    }

    @Test
    @DisplayName("Test setOfficeFrom")
    void testOfficeFrom() {
        // Arrange
        Shipment actualShipment = new Shipment();
        Office expectedOfficeFrom = new Office();

        // Act
        actualShipment.setOfficeFrom(expectedOfficeFrom);

        // Assert
        assertSame(expectedOfficeFrom, actualShipment.getOfficeFrom());
    }

    @Test
    @DisplayName("Test setOfficeTo")
    void testOfficeTo() {
        // Arrange
        Shipment actualShipment = new Shipment();
        Office expectedOfficeTo = new Office();

        // Act
        actualShipment.setOfficeTo(expectedOfficeTo);

        // Assert
        assertSame(expectedOfficeTo, actualShipment.getOfficeTo());
    }

    @Test
    @DisplayName("Test setPrice")
    void testPrice() {
        // Arrange
        Shipment actualShipment = new Shipment();
        Double expectedPrice = 10.0;

        // Act
        actualShipment.setPrice(expectedPrice);

        // Assert
        assertEquals(expectedPrice, actualShipment.getPrice().doubleValue());
    }

    @Test
    @DisplayName("Test setReceiver")
    void testReceiver() {
        // Arrange
        Shipment actualShipment = new Shipment();
        Customer expectedReceiver = new Customer();

        // Act
        actualShipment.setReceiver(expectedReceiver);

        // Assert
        assertSame(expectedReceiver, actualShipment.getReceiver());
    }

    @Test
    @DisplayName("Test setSender")
    void testSender() {
        // Arrange
        Shipment actualShipment = new Shipment();
        Customer expectedSender = new Customer();

        // Act
        actualShipment.setSender(expectedSender);

        // Assert
        assertSame(expectedSender, actualShipment.getSender());
    }

    @Test
    @DisplayName("Test setShipmentId")
    void testShipmentId() {
        // Arrange
        Shipment actualShipment = new Shipment();
        UUID expectedShipmentId = UUID.randomUUID();

        // Act
        actualShipment.setShipmentId(expectedShipmentId);

        // Assert
        assertSame(expectedShipmentId, actualShipment.getShipmentId());
    }

    @Test
    @DisplayName("Test setWeight")
    void testWeight() {
        // Arrange
        Shipment actualShipment = new Shipment();
        Double expectedWeight = 10.0;

        // Act
        actualShipment.setWeight(expectedWeight);

        // Assert
        assertEquals(expectedWeight, actualShipment.getWeight().doubleValue());
    }
}

