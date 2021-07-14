package com.example.retrofit_api;

import com.google.gson.annotations.SerializedName;

public class post {
    private int postId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
}

