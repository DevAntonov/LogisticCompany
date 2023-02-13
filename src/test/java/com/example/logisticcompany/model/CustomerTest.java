package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Customer}
     *   <li>{@link Customer#setCompanies(Set)}
     *   <li>{@link Customer#setCustomerId(UUID)}
     *   <li>{@link Customer#setCustomer_shipments(Set)}
     *   <li>{@link Customer#setName(String)}
     *   <li>{@link Customer#getCompanies()}
     *   <li>{@link Customer#getCustomerId()}
     *   <li>{@link Customer#getCustomer_shipments()}
     *   <li>{@link Customer#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer();
        HashSet<Company> companySet = new HashSet<>();
        actualCustomer.setCompanies(companySet);
        UUID randomUUIDResult = UUID.randomUUID();
        actualCustomer.setCustomerId(randomUUIDResult);
        HashSet<Shipment> shipmentSet = new HashSet<>();
        actualCustomer.setCustomer_shipments(shipmentSet);
        actualCustomer.setName("Ime");
        assertSame(companySet, actualCustomer.getCompanies());
        assertSame(randomUUIDResult, actualCustomer.getCustomerId());
        assertSame(shipmentSet, actualCustomer.getCustomer_shipments());
        assertEquals("Ime", actualCustomer.getName());
    }
}

