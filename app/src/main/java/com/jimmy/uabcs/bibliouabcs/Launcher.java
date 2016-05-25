package com.jimmy.uabcs.bibliouabcs;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jimmy.uabcs.bibliouabcs.utils.Utils;
import com.jimmy.uabcs.bibliouabcs.views.LoginActivity;
import com.jimmy.uabcs.bibliouabcs.views.MainActivity;

import static com.jimmy.uabcs.bibliouabcs.utils.Utils.*;

public class Launcher extends AppCompatActivity {
    private static final long SPLASH_DELAY = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        init();
    }

    private void init(){
        if (checkSession()){
            gotoActivity(MainActivity.class);
        } else {
            gotoActivity(LoginActivity.class);
        }
    }

    private void gotoActivity(final Class clazz) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivityHome(Launcher.this, clazz);
            }
        }, SPLASH_DELAY);
    }

    private boolean checkSession (){
        return false;
    }
}
