package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoleTest {
    @Test
    void testValueOf() {
        // Arrange, Act and Assert
        assertEquals("OfficeWorker", Role.valueOf("OFFICEWORKER").getValue());
        assertEquals("Client", Role.valueOf("CLIENT").getValue());
        assertEquals("Courier", Role.valueOf("COURIER").getValue());
        assertEquals("User", Role.valueOf("USER").getValue());
        assertEquals("Admin", Role.valueOf("ADMIN").getValue());
    }
}

