package com.coreo.model;

import java.sql.Timestamp;

public class Comments {
    private int id;
    private int userId;
    private int videoId;
    private String text;
    private Timestamp createdAt;

    public Comments(){}
    public Comments(int id, int userId, int videoId, String text, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
