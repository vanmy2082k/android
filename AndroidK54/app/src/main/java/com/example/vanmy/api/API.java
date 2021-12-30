package com.example.vanmy.api;

import com.example.vanmy.model.Count;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface API {
    //https://tms.tnut.edu.vn/api.aspx?action=counter_online
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    API api = new Retrofit.Builder().
            baseUrl("https://tms.tnut.edu.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(API.class);
    @GET("api.aspx")
    Call<Count> sendCount(@Query("action") String action);
}
