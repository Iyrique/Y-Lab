package com.ylab.model;

/**
 * Represents a user of the coworking service.
 */
public class User {

    private String username;
    private String password;
    private String name;

    /**
     * Constructs a new user.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param name     the name of the user
     */
    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the name of the user.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
