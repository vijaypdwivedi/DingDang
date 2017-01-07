package com.vpd.dwivedi.dingdang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

/**
 * Created by Vijay on 10/30/2016.
 */

public class PlayerActivity extends AppCompatActivity {

    TextView player1, player2;
    Button back, next;
    EditText editPlayer1, editPlayer2;
    String playerName1, playerName2;
    Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_name);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        player1=(TextView)findViewById(R.id.textplayer1);
        player2=(TextView)findViewById(R.id.textplayer2);
        editPlayer1=(EditText)findViewById(R.id.editTextplayer1);
        editPlayer2=(EditText)findViewById(R.id.editTextPlayer2);
        next=(Button)findViewById(R.id.next);
        back=(Button)findViewById(R.id.back);



        intent=new Intent(this, HumenActivity.class);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(PlayerActivity.this, MainMenu.class);
                intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerName1=editPlayer1.getText().toString().toUpperCase();
                playerName2=editPlayer2.getText().toString().toUpperCase();
                if (playerName1.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter the name of player 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (playerName2.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter the name of player 2", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(playerName1.equals(playerName2)){
                    Toast.makeText(getApplicationContext(), "PLAYER 1 and PLAYER 2 MUST HAVE DIFFERENT NAME", Toast.LENGTH_SHORT).show();
                    return;

                }
                intent.putExtra("playerName1",playerName1);
                intent.putExtra("playerName2",playerName2);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "RED Colour is player 1", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
