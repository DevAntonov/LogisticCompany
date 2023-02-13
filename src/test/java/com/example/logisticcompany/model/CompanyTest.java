package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CompanyTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Company}
     *   <li>{@link Company#toString()}
     *   <li>{@link Company#getCompanyId()}
     *   <li>{@link Company#getCompanyName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Company actualCompany = new Company();
        String actualToStringResult = actualCompany.toString();
        assertNull(actualCompany.getCompanyId());
        assertNull(actualCompany.getCompanyName());
        assertEquals(
                "{companyId=null, companyName='null', customerList=[], allShipments=null, offices=null," + " employees=null}",
                actualToStringResult);
    }
}

