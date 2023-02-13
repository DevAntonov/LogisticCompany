package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CompanyTest {

    @Test
    void testConstructor() {
        // Arrange and Act
        Company actualCompany = new Company();
        String actualToStringResult = actualCompany.toString();

        // Assert
        assertNull(actualCompany.getCompanyId());
        assertNull(actualCompany.getCompanyName());
        assertEquals(
                "{companyId=null, companyName='null', customerList=[], allShipments=null, offices=null," + " employees=null}",
                actualToStringResult);
    }

}

