package com.ylab.model;

import java.time.LocalDateTime;

/**
 * Represents a booking in the coworking service.
 */
public class Booking {
    private int id;
    private String username;
    private int resourceId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isWorkspace;

    /**
     * Constructs a new booking.
     *
     * @param id          the ID of the booking
     * @param username    the username of the user who made the booking
     * @param resourceId  the ID of the resource being booked
     * @param startTime   the start time of the booking
     * @param endTime     the end time of the booking
     * @param isWorkspace true if the resource is a workspace, false if it is a conference room
     */
    public Booking(int id, String username, int resourceId, LocalDateTime startTime, LocalDateTime endTime, boolean isWorkspace) {
        this.id = id;
        this.username = username;
        this.resourceId = resourceId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isWorkspace = isWorkspace;
    }

    /**
     * Gets the ID of the booking.
     *
     * @return the ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the username of the user who made the booking.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the ID of the resource being booked.
     *
     * @return the resource ID
     */
    public int getResourceId() {
        return resourceId;
    }

    /**
     * Gets the start time of the booking.
     *
     * @return the start time
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Gets the end time of the booking.
     *
     * @return the end time
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Checks if the resource is a workspace.
     *
     * @return true if it is a workspace, false if it is a conference room
     */
    public boolean isWorkspace() {
        return isWorkspace;
    }

}
