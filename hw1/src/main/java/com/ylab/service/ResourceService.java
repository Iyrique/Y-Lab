package com.ylab.service;

import com.ylab.model.ConferenceRoom;
import com.ylab.model.Workspace;

import java.util.HashMap;
import java.util.Map;

/**
 * Service for managing workspaces and conference rooms.
 */
public class ResourceService {

    private Map<Integer, Workspace> workspaces = new HashMap<>();
    private Map<Integer, ConferenceRoom> conferenceRooms = new HashMap<>();
    private int workspaceCounter = 0;
    private int conferenceRoomCounter = 0;

    /**
     * Adds a new workspace.
     *
     * @param name the name of the new workspace
     */
    public void addWorkspace(String name) {
        workspaceCounter++;
        workspaces.put(workspaceCounter, new Workspace(workspaceCounter, name));
    }

    /**
     * Adds a new conference room.
     *
     * @param name the name of the new conference room
     */
    public void addConferenceRoom(String name) {
        conferenceRoomCounter++;
        conferenceRooms.put(conferenceRoomCounter, new ConferenceRoom(conferenceRoomCounter, name));
    }

    /**
     * Updates an existing workspace.
     *
     * @param id      the ID of the workspace
     * @param newName the new name of the workspace
     */
    public void updateWorkspace(int id, String newName) {
        Workspace workspace = workspaces.get(id);
        if (workspace != null) {
            workspace.setName(newName);
        }
    }

    /**
     * Updates an existing conference room.
     *
     * @param id      the ID of the conference room
     * @param newName the new name of the conference room
     */
    public void updateConferenceRoom(int id, String newName) {
        ConferenceRoom room = conferenceRooms.get(id);
        if (room != null) {
            room.setName(newName);
        }
    }

    /**
     * Deletes an existing workspace.
     *
     * @param id the ID of the workspace
     */
    public void deleteWorkspace(int id) {
        workspaces.remove(id);
    }

    /**
     * Deletes an existing conference room.
     *
     * @param id the ID of the conference room
     */
    public void deleteConferenceRoom(int id) {
        conferenceRooms.remove(id);
    }

    /**
     * Gets a workspace by ID.
     *
     * @param id the ID of the workspace
     * @return the workspace, or null if no such workspace exists
     */
    public Workspace getWorkspace(int id) {
        return workspaces.get(id);
    }

    /**
     * Gets a conference room by ID.
     *
     * @param id the ID of the conference room
     * @return the conference room, or null if no such conference room exists
     */
    public ConferenceRoom getConferenceRoom(int id) {
        return conferenceRooms.get(id);
    }

    /**
     * Gets all workspaces.
     *
     * @return a map of all workspaces
     */
    public Map<Integer, Workspace> getAllWorkspaces() {
        return workspaces;
    }

    /**
     * Gets all conference rooms.
     *
     * @return a map of all conference rooms
     */
    public Map<Integer, ConferenceRoom> getAllConferenceRooms() {
        return conferenceRooms;
    }
}
