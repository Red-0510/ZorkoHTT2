package com.example.zorkohtt2.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://10.0.2.2:8000/api/";
    private static RetrofitClient mIs;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(mIs==null){
            mIs = new RetrofitClient();
        }
        return mIs;
    }
    public API getAPI(){
        return retrofit.create(API.class);
    }
}