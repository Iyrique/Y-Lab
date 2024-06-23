package com.ylab.service;

import com.ylab.model.ConferenceRoom;
import com.ylab.model.Workspace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for ResourceService.
 */
public class ResourceServiceTest {

    private ResourceService resourceService;

    @BeforeEach
    public void setUp() {
        resourceService = new ResourceService();
    }

    @Test
    @DisplayName("Test adding workspace")
    public void testAddWorkspace() {
        resourceService.addWorkspace("Workspace One");
        Workspace workspace = resourceService.getWorkspace(1);

        assertThat(workspace).isNotNull();
        assertThat(workspace.getName()).isEqualTo("Workspace One");
    }

    @Test
    @DisplayName("Test adding conference room")
    public void testAddConferenceRoom() {
        resourceService.addConferenceRoom("Conference Room One");
        ConferenceRoom room = resourceService.getConferenceRoom(1);

        assertThat(room).isNotNull();
        assertThat(room.getName()).isEqualTo("Conference Room One");
    }

    @Test
    @DisplayName("Test updating workspace")
    public void testUpdateWorkspace() {
        resourceService.addWorkspace("Workspace One");
        resourceService.updateWorkspace(1, "Updated Workspace One");
        Workspace workspace = resourceService.getWorkspace(1);

        assertThat(workspace).isNotNull();
        assertThat(workspace.getName()).isEqualTo("Updated Workspace One");
    }

    @Test
    @DisplayName("Test updating conference room")
    public void testUpdateConferenceRoom() {
        resourceService.addConferenceRoom("Conference Room One");
        resourceService.updateConferenceRoom(1, "Updated Conference Room One");
        ConferenceRoom room = resourceService.getConferenceRoom(1);

        assertThat(room).isNotNull();
        assertThat(room.getName()).isEqualTo("Updated Conference Room One");
    }

    @Test
    @DisplayName("Test deleting workspace")
    public void testDeleteWorkspace() {
        resourceService.addWorkspace("Workspace One");
        resourceService.deleteWorkspace(1);
        Workspace workspace = resourceService.getWorkspace(1);

        assertThat(workspace).isNull();
    }

    @Test
    @DisplayName("Test deleting conference room")
    public void testDeleteConferenceRoom() {
        resourceService.addConferenceRoom("Conference Room One");
        resourceService.deleteConferenceRoom(1);
        ConferenceRoom room = resourceService.getConferenceRoom(1);

        assertThat(room).isNull();
    }

    @Test
    @DisplayName("Test getting workspaces")
    public void testGetAllWorkspaces() {
        resourceService.addWorkspace("Workspace One");
        resourceService.addWorkspace("Workspace Two");

        assertThat(resourceService.getAllWorkspaces()).hasSize(2);
    }

    @Test
    @DisplayName("Test getting conference rooms")
    public void testGetAllConferenceRooms() {
        resourceService.addConferenceRoom("Conference Room One");
        resourceService.addConferenceRoom("Conference Room Two");

        assertThat(resourceService.getAllConferenceRooms()).hasSize(2);
    }
}
