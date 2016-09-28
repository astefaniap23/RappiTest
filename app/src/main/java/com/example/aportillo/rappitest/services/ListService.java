package com.example.aportillo.rappitest.services;

import android.content.Context;
import android.util.Log;

import com.example.aportillo.rappitest.constans.MobileConstant;
import com.example.aportillo.rappitest.services.interfaces.ListServiceI;

import retrofit2.Call;

/**
 * Created by aportillo on 27/09/2016.
 */
public class ListService<T>extends  BaseServices {

    private ListServiceI listServiceI;
    private ServiceGenerator serviceGenerator;

    public ListService(String baseUrl) {
        super(baseUrl);
        this.listServiceI = getRetrofit().create(ListServiceI.class);
    }

    public void getListDataService(ServiceInterface<T> serviceInterface){
        try {
            serviceGenerator = new ServiceGenerator();
            this.listServiceI = getRetrofit().create(ListServiceI.class);
            Call<T> aCall = (Call<T>) this.listServiceI.callList();
            serviceGenerator.response(aCall, serviceInterface);
        } catch (Exception e) {
            Log.e(MobileConstant.msgError, getClass().getSimpleName() + ":" + e.getMessage());
        }
    }
}
