package com.example.retrofit_api;

import org.w3c.dom.Comment;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface jason
{
    @GET("posts/1/comments")
    Call<List<post>> getPosts(@Query("userId") Integer[] userId,//for more than one id's

                              @Query("_sort") String sort,
                              @Query("_order") String order);
}
