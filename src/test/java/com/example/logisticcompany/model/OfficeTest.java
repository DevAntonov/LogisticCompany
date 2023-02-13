package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class OfficeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Office}
     *   <li>{@link Office#setCompany(Company)}
     *   <li>{@link Office#setCompanyOfficeId(UUID)}
     *   <li>{@link Office#setOfficeAddress(String)}
     *   <li>{@link Office#setShipments(Set)}
     *   <li>{@link Office#getCompany()}
     *   <li>{@link Office#getCompanyOfficeId()}
     *   <li>{@link Office#getOfficeAddress()}
     *   <li>{@link Office#getShipments()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Office actualOffice = new Office();
        Company company = new Company();
        company.setAllShipments(new HashSet<>());
        company.setCompanyId(UUID.randomUUID());
        company.setCompanyName("kompaniq");
        company.setCustomerList(new HashSet<>());
        company.setEmployees(new HashSet<>());
        company.setOffices(new HashSet<>());
        actualOffice.setCompany(company);
        UUID randomUUIDResult = UUID.randomUUID();
        actualOffice.setCompanyOfficeId(randomUUIDResult);
        actualOffice.setOfficeAddress("ulica 1");
        HashSet<Shipment> shipmentSet = new HashSet<>();
        actualOffice.setShipments(shipmentSet);
        assertSame(company, actualOffice.getCompany());
        assertSame(randomUUIDResult, actualOffice.getCompanyOfficeId());
        assertEquals("ulica 1", actualOffice.getOfficeAddress());
        assertSame(shipmentSet, actualOffice.getShipments());
    }
}

