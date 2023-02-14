package com.example.logisticcompany.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class UserTest {

    @Test
    void testGetAuthorities2() {
        // Arrange
        User user = new User();
        user.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setEmail("test@abv.bg");
        user.setEnabled(true);
        user.setFirstName("Pesho");
        user.setLastName("Peshev");
        user.setLocked(true);
        user.setMobile("0888888889");
        user.setPassword("password");
        user.setRole(Role.OFFICEWORKER);
        user.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserID(UUID.randomUUID());

        // Act
        Collection<? extends GrantedAuthority> actualAuthorities = user.getAuthorities();

        // Assert
        assertEquals(1, actualAuthorities.size());
        assertEquals("OFFICEWORKER", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    @Test
    void testIsAccountNonLocked() {
        // Arrange, Act and Assert
        assertTrue((new User()).isAccountNonLocked());
    }

    @Test
    void testIsAccountNonLocked2() {
        // Arrange
        User user = new User();
        user.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setEmail("test@abv.bg");
        user.setEnabled(true);
        user.setFirstName("Pesho");
        user.setLastName("Peshev");
        user.setLocked(true);
        user.setMobile("0888888889");
        user.setPassword("password");
        user.setRole(Role.OFFICEWORKER);
        user.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserID(UUID.randomUUID());

        // Act and Assert
        assertFalse(user.isAccountNonLocked());
    }

    @Test
    void testIsEnabled() {
        // Arrange, Act and Assert
        assertTrue((new User()).isEnabled());
    }

    @Test
    void testIsEnabled2() {
        // Arrange
        User user = new User();
        user.setEnabled(false);

        // Act and Assert
        assertFalse(user.isEnabled());
    }


    @Test
    void testConstructor() {
        // Arrange and Act
        User actualUser = new User();
        actualUser.setEmail("test@abv.bg");
        actualUser.setFirstName("Pesho");
        actualUser.setLastName("Peshev");
        actualUser.setMobile("0888888889");
        actualUser.setPassword("password");
        actualUser.setRole(Role.OFFICEWORKER);

        // Assert
        assertEquals("test@abv.bg", actualUser.getEmail());
        assertEquals("Pesho", actualUser.getFirstName());
        assertEquals("Peshev", actualUser.getLastName());
        assertEquals("0888888889", actualUser.getMobile());
        assertEquals("password", actualUser.getPassword());
        assertEquals(Role.OFFICEWORKER, actualUser.getRole());
        assertEquals("test@abv.bg", actualUser.getUsername());
        assertTrue(actualUser.isAccountNonExpired());
        assertTrue(actualUser.isCredentialsNonExpired());
    }
}

