package com.example.aportillo.rappitest.services;


import android.content.Context;

import com.example.aportillo.rappitest.util.constans.RestApi;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aportillo on 27/09/2016.
 */
public class BaseServices {

    private String baseUrl;
    private Retrofit retrofit;
    private File httpCacheDirectory;
    private OkHttpClient httpClient;
    private Context context;
    public BaseServices() {
    }

   public BaseServices(String baseUrl) {
        this.baseUrl = baseUrl;


        this.retrofit = new Retrofit.Builder()
                .baseUrl(RestApi.BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public BaseServices(String baseUrl,Context context) {
        httpCacheDirectory = new File(context.getCacheDir(),  "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        httpClient = new OkHttpClient.Builder()
                //.addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR)
                //.addInterceptor(OFFLINE_INTERCEPTOR)
                .cache(cache)
                .build();
        this.baseUrl = baseUrl;
        this.context= context;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(RestApi.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
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


//------------------------------

    /*private static final Interceptor REWRITE_RESPONSE_INTERCEPTOR = chain -> {
        okhttp3.Response originalResponse = chain.proceed(chain.request());
        String cacheControl = originalResponse.header("Cache-Control");

        if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") || cacheControl.contains("max-age=0")) {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 10)
                    .build();
        } else {
            return originalResponse;
        }
    };

    private final Interceptor OFFLINE_INTERCEPTOR = chain -> {
        Request request = chain.request();

        if (!isOnline()) {
            //Log.d(TAG, "rewriting request");

            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
            request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }

        return chain.proceed(request);
    };

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }*/

}



