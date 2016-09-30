package com.example.aportillo.rappitest.services.interfaces;

import com.example.aportillo.rappitest.models.ListData;
import com.example.aportillo.rappitest.util.constans.RestApi;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aportillo on 27/09/2016.
 */
public interface ListServiceI {

    @GET(RestApi.SERVICE_URL)
    Call<ListData> callList();
}
