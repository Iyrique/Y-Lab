package com.ylab.model;

/**
 * Represents a conference room in the coworking service.
 */
public class ConferenceRoom {

    private int id;
    private String name;
    private boolean isAvailable;

    /**
     * Constructs a new conference room.
     *
     * @param id   the ID of the conference room
     * @param name the name of the conference room
     */
    public ConferenceRoom(int id, String name) {
        this.id = id;
        this.name = name;
        this.isAvailable = true;
    }

    /**
     * Gets the ID of the conference room.
     *
     * @return the ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the name of the conference room.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the conference room.
     *
     * @param name the new name of the workspace
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the conference room is available.
     *
     * @return true if available, false otherwise
     */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    /**
     * Sets the availability of the conference room.
     *
     * @param available true if available, false otherwise
     */
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
