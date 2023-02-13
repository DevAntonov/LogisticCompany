package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Employee}
     *   <li>{@link Employee#setCompany(Company)}
     *   <li>{@link Employee#setEmail(String)}
     *   <li>{@link Employee#setEmployeeId(UUID)}
     *   <li>{@link Employee#setName(String)}
     *   <li>{@link Employee#setOffice(Office)}
     *   <li>{@link Employee#setPhone(String)}
     *   <li>{@link Employee#getCompany()}
     *   <li>{@link Employee#getEmail()}
     *   <li>{@link Employee#getEmployeeId()}
     *   <li>{@link Employee#getName()}
     *   <li>{@link Employee#getOffice()}
     *   <li>{@link Employee#getPhone()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Employee actualEmployee = new Employee();
        Company company = new Company();
        company.setAllShipments(new HashSet<>());
        company.setCompanyId(UUID.randomUUID());
        company.setCompanyName("kompaniq");
        company.setCustomerList(new HashSet<>());
        company.setEmployees(new HashSet<>());
        company.setOffices(new HashSet<>());
        actualEmployee.setCompany(company);
        actualEmployee.setEmail("test@abv.bg");
        UUID randomUUIDResult = UUID.randomUUID();
        actualEmployee.setEmployeeId(randomUUIDResult);
        actualEmployee.setName("ime");
        Company company1 = new Company();
        company1.setAllShipments(new HashSet<>());
        company1.setCompanyId(UUID.randomUUID());
        company1.setCompanyName("kompaniq");
        company1.setCustomerList(new HashSet<>());
        company1.setEmployees(new HashSet<>());
        company1.setOffices(new HashSet<>());
        Office office = new Office();
        office.setCompany(company1);
        office.setCompanyOfficeId(UUID.randomUUID());
        office.setOfficeAddress("ulica 1");
        office.setShipments(new HashSet<>());
        actualEmployee.setOffice(office);
        actualEmployee.setPhone("0888888888");
        assertSame(company, actualEmployee.getCompany());
        assertEquals("test@abv.bg", actualEmployee.getEmail());
        assertSame(randomUUIDResult, actualEmployee.getEmployeeId());
        assertEquals("ime", actualEmployee.getName());
        assertSame(office, actualEmployee.getOffice());
        assertEquals("0888888888", actualEmployee.getPhone());
    }
}

