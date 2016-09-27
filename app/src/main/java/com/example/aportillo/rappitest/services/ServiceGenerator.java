package com.example.aportillo.rappitest.services;

import android.util.Log;
import com.example.aportillo.rappitest.R;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aportillo on 27/09/2016.
 */
public class ServiceGenerator<T> extends BaseServices {

    //Method to manage response of callback
    public void response(Call<T> call, final ServiceInterface serviceInterface) {
        call.enqueue(new Callback<T>() {

            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.i("json: ", new Gson().toJson(response.body()));
                        serviceInterface.onSuccess(response.body());
                    } else {
                        serviceInterface.onError();
                        throw new Exception(String.valueOf(R.string.is_not_successful));
                    }
                } catch (Exception e) {
                    Log.e("Error: ", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d("onFailure", t.getMessage());
            }
        });
    }
}