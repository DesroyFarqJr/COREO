package com.coreo.model;

public class Interests {
    private int id;
    private int userId;
    private int categoryId;

    public Interests(){}

    public Interests(int id, int userId, int categoryId) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}