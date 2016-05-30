package com.jimmy.uabcs.bibliouabcs;

import android.app.Application;
import android.content.Context;

import com.jimmy.uabcs.bibliouabcs.network.ApiLibrary;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App  extends Application {
    private static final String BASE_URL = "http://shimmbo-001-site1.ctempurl.com/";
    private static Context mContext;
    private static ApiLibrary api;

    @Override
    public void onCreate(){
        super.onCreate();
        mContext = this;
    }

    public static ApiLibrary getApi() {
        if (api == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(ApiLibrary.class);
        }
        return api;
    }

    public static Context getContext(){
        return mContext;
    }
}
