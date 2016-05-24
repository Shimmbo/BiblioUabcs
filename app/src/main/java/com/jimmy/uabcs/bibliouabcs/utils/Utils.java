package com.jimmy.uabcs.bibliouabcs.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

public class Utils {
    public static void startActivity(Context context, Class clazz){
        Intent mIntent = new Intent(context, clazz);
        Bundle options = new Bundle();
        ActivityCompat.startActivity((Activity)context, mIntent, options);
    }

    public static void startActivityHome(Context context, Class clazz){
        Activity activity = (Activity) context;
        Intent mIntent = new Intent(context, clazz);
        mIntent.addCategory(Intent.CATEGORY_HOME);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle options = new Bundle();
        ActivityCompat.finishAfterTransition(activity);
        ActivityCompat.startActivity(activity, mIntent, options);
    }

    public static void enableHomeAsUp(ActionBar toolbar){
        if (toolbar != null){
            toolbar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
