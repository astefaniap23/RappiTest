package com.example.aportillo.rappitest.services;


import com.example.aportillo.rappitest.constans.RestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aportillo on 27/09/2016.
 */
public class BaseServices {

    private String baseUrl;
    private Retrofit retrofit;

    public BaseServices() {
    }

    public BaseServices(String baseUrl) {
        this.baseUrl = baseUrl;


        this.retrofit = new Retrofit.Builder()
                .baseUrl(RestApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

}



