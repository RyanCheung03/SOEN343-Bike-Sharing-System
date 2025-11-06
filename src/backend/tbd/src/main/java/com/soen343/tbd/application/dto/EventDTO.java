package com.soen343.tbd.application.dto;

import java.time.LocalDateTime;

public class EventDTO {

    private String entityType; // ex bike, station or dock
    private String entityId;
    private String action;
    private String userEmail;
    private String description;
    private String previousStatus;
    private String newStatus;
    private LocalDateTime timestamp;

    public EventDTO(String type, String id, String action, String email, String description, String previousStatus,
            String newStatus) {
        this.entityType = type;
        this.entityId = id;
        this.action = action;
        this.userEmail = email;
        this.description = description;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.timestamp = LocalDateTime.now(); // moment status changes = moment event is generated so just generate
                                              // timestamp at the same time
    }

    // setters and getters
    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
