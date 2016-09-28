package com.example.aportillo.rappitest.services;

import android.util.Log;

import com.example.aportillo.rappitest.R;
import com.example.aportillo.rappitest.models.ListData;
import com.example.aportillo.rappitest.util.constans.MobileConstant;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aportillo on 27/09/2016.
 */
public class ServiceGenerator<T> extends BaseServices {

    //Method to manage response of callback
    public void response(Call<ListData> call, final ServiceInterface serviceInterface) {
        call.enqueue(new Callback<ListData>() {

            @Override
            public void onResponse(Call<ListData> call, retrofit2.Response<ListData> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.i(MobileConstant.json, new Gson().toJson(response.body()));
                        serviceInterface.onSuccess(response.body());
                    } else {
                        serviceInterface.onError();
                        throw new Exception(String.valueOf(R.string.is_not_successful));
                    }
                } catch (Exception e) {
                    Log.e(MobileConstant.error, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ListData> call, Throwable t) {
                Log.d(MobileConstant.onFailure, t.getMessage());
            }
        });
    }
}