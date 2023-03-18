package com.coreo.model;

import java.sql.Timestamp;

public class Analytics {
    private int id;
    private int videoId;
    private int views;
    private int likes;
    private int comments;
    private Timestamp createdAt;

    public Analytics(){}
    public Analytics(int id, int videoId, int views, int likes, int comments, Timestamp createdAt) {
        this.id = id;
        this.videoId = videoId;
        this.views = views;
        this.likes = likes;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
