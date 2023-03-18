package com.coreo.model;

import java.sql.Timestamp;

public class FilterVideos {
    private int id;
    private int videoId;
    private int filterId;

    public FilterVideos(){}
    public FilterVideos(int id, int videoId, int filterId) {
        this.id = id;
        this.videoId = videoId;
        this.filterId = filterId;
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

    public int getFilterId() {
        return filterId;
    }

    public void setFilterId(int filterId) {
        this.filterId = filterId;
    }
}