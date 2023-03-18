package com.coreo.model;

import java.sql.Timestamp;

public class Collaborations {
    private int id;
    private int userId;
    private int collaboratorUserId;
    private Timestamp createdAt;

    public Collaborations(){}
    public Collaborations(int id, int userId, int collaboratorUserId, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.collaboratorUserId = collaboratorUserId;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCollaboratorUserId() {
        return collaboratorUserId;
    }

    public void setCollaboratorUserId(int collaboratorUserId) {
        this.collaboratorUserId = collaboratorUserId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
