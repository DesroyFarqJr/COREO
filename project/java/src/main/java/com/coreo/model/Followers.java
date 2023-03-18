package com.coreo.model;

import java.sql.Timestamp;

public class Followers {
    private int id;
    private int userId;
    private int followerUserId;
    private Timestamp createdAt;

    public Followers(){}

    public Followers(int id, int userId, int followerUserId, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.followerUserId = followerUserId;
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

    public int getFollowerUserId() {
        return followerUserId;
    }

    public void setFollowerUserId(int followerUserId) {
        this.followerUserId = followerUserId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
