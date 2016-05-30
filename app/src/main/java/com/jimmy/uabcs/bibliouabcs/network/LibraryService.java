package com.jimmy.uabcs.bibliouabcs.network;

import android.util.Log;

import com.jimmy.uabcs.bibliouabcs.App;
import com.jimmy.uabcs.bibliouabcs.models.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LibraryService {
    private static final String TAG = "library";

    public static void login(UserLogin loginModel){
        Call<LoginResponse> call = App.getApi().login(loginModel);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.i(TAG, response.message());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
