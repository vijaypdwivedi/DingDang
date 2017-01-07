package com.vpd.dwivedi.dingdang;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Vijay on 8/25/2016.
 */
public class MainMenu extends AppCompatActivity {

    Button newGame,aboutGame,exitGame, againstHuman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        newGame=(Button)findViewById(R.id.newgame);
        aboutGame=(Button)findViewById(R.id.about);
        exitGame=(Button)findViewById(R.id.exit);
        againstHuman=(Button)findViewById(R.id.against);


        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainMenu.this,MainActivity.class);
                startActivity(intent);
            }
        });

        aboutGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(MainMenu.this, AboutActivity.class);
                startActivity(in);
            }
        });

        againstHuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainMenu.this,PlayerActivity.class);
                startActivity(intent);

            }
        });

        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.exit(0);

            }
        });


    }


}
