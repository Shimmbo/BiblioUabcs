package com.jimmy.uabcs.bibliouabcs.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.jimmy.uabcs.bibliouabcs.App;
import com.jimmy.uabcs.bibliouabcs.models.LoginResponse;
import com.jimmy.uabcs.bibliouabcs.views.LoginActivity;

import static com.jimmy.uabcs.bibliouabcs.utils.Constants.*;

public class PrefsUtils {
    private SharedPreferences mPrefs;

    private Editor mEditor;


    public PrefsUtils(){
        mPrefs = App.getContext().getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        mEditor = mPrefs.edit();
    }

    public void saveUserSession(LoginResponse user){
        mEditor.putBoolean(IS_USER_LOGIN, true);
        String json = GSON.toJson(user);
        mEditor.putString(KEY_USER, json);
        mEditor.commit();
    }

    public LoginResponse getUserDetails(){
        String json = mPrefs.getString(KEY_USER, null);
        return GSON.fromJson(json, LoginResponse.class);
    }

    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();
        Utils.startActivity(App.getContext(), LoginActivity.class);
    }

    public boolean isUserLoggedIn(){
        return mPrefs.getBoolean(IS_USER_LOGIN, false);
    }
}
