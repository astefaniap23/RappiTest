package com.example.aportillo.rappitest.services.interfaces;

import com.example.aportillo.rappitest.models.ListData;
import com.example.aportillo.rappitest.util.constans.RestApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by aportillo on 27/09/2016.
 */
public interface ListServiceI {

    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET(RestApi.SERVICE_URL)
    Call<ListData> callList();
}
