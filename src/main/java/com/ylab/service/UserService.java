package com.ylab.service;

import com.ylab.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Service for managing users.
 */
public class UserService {
    private Map<String, User> users = new HashMap<>();

    /**
     * Adds (Register) a new user.
     *
     * @param username the username of the new user
     * @param password the password of the new user
     * @param name     the name of the new user
     */
    public void addUser(String username, String password, String name) {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("User already exists");
        }
        users.put(username, new User(username, password, name));
    }

    /**
     * Gets a user by username.
     *
     * @param username the username of the user
     * @return the user, or null if no such user exists
     */
    public User getUser(String username) {
        return users.get(username);
    }

    /**
     * Authenticates a user.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return true if the username and password match, false otherwise
     */
    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
