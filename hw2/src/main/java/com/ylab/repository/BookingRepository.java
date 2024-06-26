package com.ylab.repository;

import com.ylab.connector.ConnectorDB;
import com.ylab.model.Booking;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for Booking entity.
 */
public class BookingRepository {

    /**
     * Saves a booking to the database.
     *
     * @param booking the booking to save
     */
    public void save(Booking booking) {
        try {
            Connection connection = ConnectorDB.getInstance().getConnection();
            String sql = "INSERT INTO coworking.bookings (username, resource_id, start_time, end_time, is_workspace) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, booking.getUsername());
            statement.setInt(2, booking.getResourceId());
            statement.setTimestamp(3, Timestamp.valueOf(booking.getStartTime()));
            statement.setTimestamp(4, Timestamp.valueOf(booking.getEndTime()));
            statement.setBoolean(5, booking.isWorkspace());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cancels a booking by ID.
     *
     * @param id the ID of the booking to cancel
     */
    public void cancel(int id) {
        try {
            Connection connection = ConnectorDB.getInstance().getConnection();
            String sql = "DELETE FROM coworking.bookings WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all bookings from the database.
     *
     * @return a list of all bookings
     */
    public List<Booking> findAll() {
        List<Booking> bookings = new ArrayList<>();
        try {
            Connection connection = ConnectorDB.getInstance().getConnection();
            String sql = "SELECT * FROM coworking.bookings";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bookings.add(new Booking(resultSet.getLong("id"), resultSet.getString("username"),
                        resultSet.getInt("resource_id"), resultSet.getTimestamp("start_time").toLocalDateTime(),
                        resultSet.getTimestamp("end_time").toLocalDateTime(), resultSet.getBoolean("is_workspace")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    /**
     * Filters bookings based on the provided criteria.
     *
     * @param date       the date to filter by
     * @param username   the username to filter by
     * @param resourceId the resource ID to filter by
     * @return a list of filtered bookings
     */
    public List<Booking> filter(LocalDateTime date, String username, Integer resourceId) {
        List<Booking> bookings = new ArrayList<>();
        try {
            Connection connection = ConnectorDB.getInstance().getConnection();
            StringBuilder sql = new StringBuilder("SELECT * FROM coworking.bookings WHERE 1=1");
            if (date != null) {
                sql.append(" AND start_time >= '").append(Timestamp.valueOf(date)).append("'")
                        .append(" AND end_time <= '").append(Timestamp.valueOf(date.plusDays(1))).append("'");
            }
            if (username != null && !username.isEmpty()) {
                sql.append(" AND username = '").append(username).append("'");
            }
            if (resourceId != null) {
                sql.append(" AND resource_id = ").append(resourceId);
            }

            PreparedStatement statement = connection.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bookings.add(new Booking(resultSet.getLong("id"), resultSet.getString("username"),
                        resultSet.getInt("resource_id"), resultSet.getTimestamp("start_time").toLocalDateTime(),
                        resultSet.getTimestamp("end_time").toLocalDateTime(), resultSet.getBoolean("is_workspace")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
