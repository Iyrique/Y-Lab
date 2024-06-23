package com.ylab.model;

/**
 * Represents a workspace in the coworking service.
 */
public class Workspace {

    private int id;
    private String name;
    private boolean isAvailable;

    /**
     * Constructs a new workspace.
     *
     * @param id   the ID of the workspace
     * @param name the name of the workspace
     */
    public Workspace(int id, String name) {
        this.id = id;
        this.name = name;
        this.isAvailable = true;
    }

    /**
     * Gets the ID of the workspace.
     *
     * @return the ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the name of the workspace.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the workspace.
     *
     * @param name the new name of the workspace
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the workspace is available.
     *
     * @return true if available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets the availability of the workspace.
     *
     * @param available true if available, false otherwise
     */
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
