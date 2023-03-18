package com.coreo.model;

public class Videos {
    private int id;
    private int userId;
    private String title;
    private String description;
    private String[] tags;
    private int duration;
    private String fileName;
    private String thumbnailName;

    public Videos(){}
    public Videos(int id, int userId, String title, String description, String[] tags, int duration, String fileName, String thumbnailName) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.duration = duration;
        this.fileName = fileName;
        this.thumbnailName = thumbnailName;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getThumbnailName() {
        return thumbnailName;
    }

    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
    }
}
