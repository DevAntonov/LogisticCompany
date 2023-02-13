package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    @DisplayName("Test get and set company")
    void testGetAndSetCompany() {
        // Arrange
        Employee actualEmployee = new Employee();
        Company expectedCompany = new Company();
        expectedCompany.setAllShipments(new HashSet<>());
        expectedCompany.setCompanyId(UUID.randomUUID());
        expectedCompany.setCompanyName("kompaniq");
        expectedCompany.setCustomerList(new HashSet<>());
        expectedCompany.setEmployees(new HashSet<>());
        expectedCompany.setOffices(new HashSet<>());

        // Act
        actualEmployee.setCompany(expectedCompany);

        // Assert
        assertSame(expectedCompany, actualEmployee.getCompany());
    }

    @Test
    @DisplayName("Test get and set employee email")
    void testGetAndSetEmail() {
        // Arrange
        Employee actualEmployee = new Employee();
        String expectedEmail = "test@abv.bg";

        // Act
        actualEmployee.setEmail(expectedEmail);

        // Assert
        assertEquals(expectedEmail, actualEmployee.getEmail());
    }

    @Test
    @DisplayName("Test get and set employee ID")
    void testGetAndSetEmployeeId() {
        // Arrange
        Employee actualEmployee = new Employee();
        UUID expectedEmployeeId = UUID.randomUUID();

        // Act
        actualEmployee.setEmployeeId(expectedEmployeeId);

        // Assert
        assertSame(expectedEmployeeId, actualEmployee.getEmployeeId());
    }

    @Test
    @DisplayName("Test get and set employee name")
    void testGetAndSetName() {
        // Arrange
        Employee actualEmployee = new Employee();
        String expectedName = "Pesho";

        // Act
        actualEmployee.setName(expectedName);

        // Assert
        assertEquals(expectedName, actualEmployee.getName());
    }

    @Test
    @DisplayName("Test get and set office")
    void testGetAndSetOffice() {
        // Arrange
        Employee actualEmployee = new Employee();
        Company company = new Company();
        company.setAllShipments(new HashSet<>());
        company.setCompanyId(UUID.randomUUID());
        company.setCompanyName("kompaniq1");
        company.setCustomerList(new HashSet<>());
        company.setEmployees(new HashSet<>());
        company.setOffices(new HashSet<>());
        Office expectedOffice = new Office();
        expectedOffice.setCompany(company);
        expectedOffice.setCompanyOfficeId(UUID.randomUUID());
        expectedOffice.setOfficeAddress("ulica 1");
        expectedOffice.setShipments(new HashSet<>());

        // Act
        actualEmployee.setOffice(expectedOffice);

        // Assert
        assertSame(expectedOffice, actualEmployee.getOffice());
    }

    @Test
    @DisplayName("Test get and set employee phone")
    void testGetAndSetPhone() {
        // Arrange
        Employee actualEmployee = new Employee();
        String expectedPhone = "0888888888";

        // Act
        actualEmployee.setPhone(expectedPhone);

        // Assert
        assertEquals(expectedPhone, actualEmployee.getPhone());
    }
}


