package com.example.retrofit_api;

import com.google.gson.annotations.SerializedName;

import java.security.PrivateKey;

public class comment {
    private int postid;
    private int id;
    private String name;
    private  String email;

    @SerializedName("body")
    private String Text;

    public int getPostid() {
        return postid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return Text;
    }
}
