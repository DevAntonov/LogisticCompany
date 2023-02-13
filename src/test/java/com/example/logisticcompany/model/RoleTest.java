package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoleTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#valueOf(String)}
     *   <li>{@link Role#getValue()}
     * </ul>
     */
    @Test
    void testValueOf() {
        assertEquals("OfficeWorker", Role.valueOf("OFFICEWORKER").getValue());
    }
}

