package com.coreo.model;

import java.sql.Timestamp;

public class Notifications {
    private int id;
    private int userId;
    private String notificationType;
    private String notificationText;
    private int videoId;
    private Timestamp createdAt;

    public Notifications(){}

    public Notifications(int id, int userId, String notificationType, String notificationText, int videoId, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.notificationType = notificationType;
        this.notificationText = notificationText;
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

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
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