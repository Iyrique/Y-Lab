package com.ylab.service;

import com.ylab.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for UserService.
 */
public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testAddUser() {
        userService.addUser("user1", "password", "User One");
        User user = userService.getUser("user1");

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("user1");
        assertThat(user.getName()).isEqualTo("User One");
    }

    @Test
    public void testAddUserDuplicateUsername() {
        userService.addUser("user1", "password", "User One");
        assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser("user1", "password", "User Two");
        });
    }

    @Test
    public void testAuthenticate() {
        userService.addUser("user1", "password", "User One");
        boolean result = userService.authenticate("user1", "password");

        assertThat(result).isTrue();
    }

    @Test
    public void testAuthenticateInvalidCredentials() {
        userService.addUser("user1", "password", "User One");
        boolean result = userService.authenticate("user1", "wrongpassword");

        assertThat(result).isFalse();
    }
}
