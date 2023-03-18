package com.coreo.model;

public class ChallengeVideos {
    private int id;
    private int videoId;
    private int challengeId;

    public ChallengeVideos(){}
    public ChallengeVideos(int id, int videoId, int challengeId) {
        this.id = id;
        this.videoId = videoId;
        this.challengeId = challengeId;
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

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }
}
