package com.coreo.model;

import java.sql.Timestamp;

public class Likes {
    private int id;
    private int userId;
    private int videoId;
    private Timestamp createdAt;

    public Likes(){}
    public Likes(int id, int userId, int videoId, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
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

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
