package com.jimmy.uabcs.bibliouabcs;

import android.app.Application;
import android.content.Context;

import com.jimmy.uabcs.bibliouabcs.network.ApiLibrary;
import com.jimmy.uabcs.bibliouabcs.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class App  extends Application {
    private static final String BASE_URL = "http://shimmbo-001-site1.ctempurl.com/api/";
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
                    .addConverterFactory(GsonConverterFactory.create(Constants.GSON))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            api = retrofit.create(ApiLibrary.class);
        }
        return api;
    }

    public static Context getContext(){
        return mContext;
    }
}
