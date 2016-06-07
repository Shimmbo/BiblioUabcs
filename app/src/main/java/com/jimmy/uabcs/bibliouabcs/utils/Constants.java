package com.jimmy.uabcs.bibliouabcs.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface Constants {
    String EMPTY_STRING = "";
    String PREFER_NAME = "Prefs";
    String IS_USER_LOGIN = "IsUserLoggedIn";
    String KEY_USER = "User";
    int PRIVATE_MODE = 0;
    String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    Gson GSON = new GsonBuilder()
            .setDateFormat(DATE_FORMAT)
            .create();
}
