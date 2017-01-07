package com.vpd.dwivedi.dingdang;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vijay on 8/23/2016.
 */
public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                //call to first activity
                Intent i = new Intent(SplashActivity.this, MainMenu.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);


    }

}
