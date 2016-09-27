package com.example.aportillo.rappitest.services;


import com.example.aportillo.rappitest.constans.RestApi;

import java.util.Hashtable;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aportillo on 27/09/2016.
 */
public class BaseServices {

    private String baseUrl;
    private Retrofit retrofit;
    private String idSession;
    private String token;
    private String iso;
    private Map headers;

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

    public String getIdSession() {
        return idSession;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Map getHeaders() {
        return headers;
    }

    public void setHeaders(Hashtable headers) {
        this.headers = headers;
    }
}



