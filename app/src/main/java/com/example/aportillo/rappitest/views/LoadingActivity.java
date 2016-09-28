package com.example.aportillo.rappitest.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.aportillo.rappitest.R;
import com.example.aportillo.rappitest.constans.MobileConstant;
import com.example.aportillo.rappitest.constans.RestApi;
import com.example.aportillo.rappitest.models.ListData;
import com.example.aportillo.rappitest.services.ListService;
import com.example.aportillo.rappitest.services.ServiceInterface;

public class LoadingActivity extends AppCompatActivity {
    private ListService listService= new ListService(RestApi.BASE_URL);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        loadListData();
    }
    public void loadListData() {
        try {
            this.listService.getListDataService(new ServiceInterface<ListData>() {
                @Override
                public void onSuccess(ListData listData) {
                    Log.e(MobileConstant.onSuccess, String.valueOf(listData.getKind()));
                    Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
                    intent.putExtra("listData",  listData) ;
                    startActivity(intent);
                }
                @Override
                public void onError() {
                    Log.e(MobileConstant.msgError, MobileConstant.msgError);
                }
            } );
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "loadListData - " + e.getMessage());
        }
    }


}
