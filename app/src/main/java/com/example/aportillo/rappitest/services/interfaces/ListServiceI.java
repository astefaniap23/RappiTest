package com.example.aportillo.rappitest.services.interfaces;

import com.example.aportillo.rappitest.models.ListData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aportillo on 27/09/2016.
 */
public interface ListServiceI {

    @GET("reddits.json")
    Call<ListData> callList();
}
