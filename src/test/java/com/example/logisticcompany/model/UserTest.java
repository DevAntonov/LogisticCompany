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
    /**
     * Method under test: {@link User#getAuthorities()}
     */
    /*@Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.logisticcompany.model.Role.name()" because "this.role" is null
        //       at com.example.logisticcompany.model.User.getAuthorities(User.java:84)
        //   See https://diff.blue/R013 to resolve this issue.

        (new User()).getAuthorities();
    }*/

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link User}
     *   <li>{@link User#setLastName(String)}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User actualUser = new User();
        actualUser.setLastName("Peshev");
        assertEquals("Peshev", actualUser.getLastName());
    }

    /**
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    void testGetAuthorities2() {
        User user = new User();
        user.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setEmail("test@abv.bg");
        user.setEnabled(true);
        user.setFirstName("Pesho");
        user.setLastName("Peshev");
        user.setLocked(true);
        user.setMobile("0888888888");
        user.setPassword("password");
        user.setRole(Role.OFFICEWORKER);
        user.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserID(UUID.randomUUID());
        Collection<? extends GrantedAuthority> actualAuthorities = user.getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals("OFFICEWORKER", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    /**
     * Method under test: {@link User#isAccountNonLocked()}
     */
    @Test
    void testIsAccountNonLocked() {
        assertTrue((new User()).isAccountNonLocked());
    }

    /**
     * Method under test: {@link User#isAccountNonLocked()}
     */
    @Test
    void testIsAccountNonLocked2() {
        User user = new User();
        user.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setEmail("test@abv.bg");
        user.setEnabled(true);
        user.setFirstName("Pesho");
        user.setLastName("Peshev");
        user.setLocked(true);
        user.setMobile("0888888888");
        user.setPassword("password");
        user.setRole(Role.OFFICEWORKER);
        user.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserID(UUID.randomUUID());
        assertFalse(user.isAccountNonLocked());
    }

    /**
     * Method under test: {@link User#isEnabled()}
     */
    @Test
    void testIsEnabled() {
        assertTrue((new User()).isEnabled());
    }

    /**
     * Method under test: {@link User#isEnabled()}
     */
    @Test
    void testIsEnabled2() {
        User user = new User();
        user.setEnabled(false);
        assertFalse(user.isEnabled());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link User}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setMobile(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRole(Role)}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getMobile()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRole()}
     *   <li>{@link User#getUsername()}
     *   <li>{@link User#isAccountNonExpired()}
     *   <li>{@link User#isCredentialsNonExpired()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("test@abv.bg");
        actualUser.setFirstName("Pesho");
        actualUser.setLastName("Peshev");
        actualUser.setMobile("0888888888");
        actualUser.setPassword("password");
        actualUser.setRole(Role.OFFICEWORKER);
        assertEquals("test@abv.bg", actualUser.getEmail());
        assertEquals("Pesho", actualUser.getFirstName());
        assertEquals("Peshev", actualUser.getLastName());
        assertEquals("0888888888", actualUser.getMobile());
        assertEquals("password", actualUser.getPassword());
        assertEquals(Role.OFFICEWORKER, actualUser.getRole());
        assertEquals("test@abv.bg", actualUser.getUsername());
        assertTrue(actualUser.isAccountNonExpired());
        assertTrue(actualUser.isCredentialsNonExpired());
    }
}

