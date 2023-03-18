package com.coreo.model;

public class VideoHashtags {
    private int id;
    private int videoId;
    private int hashtagId;

    public VideoHashtags(){}
    public VideoHashtags(int id, int videoId, int hashtagId) {
        this.id = id;
        this.videoId = videoId;
        this.hashtagId = hashtagId;
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

    public int getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(int hashtagId) {
        this.hashtagId = hashtagId;
    }
}
