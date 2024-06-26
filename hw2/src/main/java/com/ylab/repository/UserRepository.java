package com.ylab.repository;

import com.ylab.connector.ConnectorDB;
import com.ylab.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Repository class for User entity.
 */
public class UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    /**
     * Saves a user to the database.
     *
     * @param user the user to save
     */
    public void save(User user) {
        String sql = "INSERT INTO coworking.users (username, password, name) VALUES (?, ?, ?)";
        try {
            Connection connection = ConnectorDB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.executeUpdate();
            logger.info("User saved: {}", user.getUsername());
        } catch (SQLException e) {
            logger.error("Error saving user", e);
        }
    }

    /**
     * Finds a user by username.
     *
     * @param username the username to search for
     * @return the user if found, null otherwise
     */
    public User findByUsername(String username) {
        String sql = "SELECT * FROM coworking.users WHERE username = ?";
        try {
            Connection connection = ConnectorDB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User(resultSet.getLong("id"), resultSet.getString("username"),
                            resultSet.getString("password"), resultSet.getString("name"));
                    logger.info("User found: {}", username);
                    return user;
                }
            }
        } catch (SQLException e) {
            logger.error("Error finding user", e);
        }
        logger.info("User not found: {}", username);
        return null;
    }
}
