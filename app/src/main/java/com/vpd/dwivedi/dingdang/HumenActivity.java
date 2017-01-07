package com.vpd.dwivedi.dingdang;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

/**
 * Created by Vijay on 10/29/2016.
 */

public class HumenActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    Button []buttonArr;


    static int  count=1;
    String player1Name, player2Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        b6=(Button) findViewById(R.id.button6);
        b7=(Button) findViewById(R.id.button7);
        b8=(Button) findViewById(R.id.button8);
        b9=(Button) findViewById(R.id.button9);
        b10=(Button) findViewById(R.id.button10);
        b11=(Button) findViewById(R.id.button11);
        buttonArr = new Button[]{b1,b2,b3,b4,b5,b6,b7,b8,b9};
        Intent intent = getIntent();
        player1Name = intent.getStringExtra("playerName1");
        player2Name = intent.getStringExtra("playerName2");

        for(Button btn : buttonArr){
            btn.setText("");
            btn.setOnClickListener(this);
        }



        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent in=new Intent(HumenActivity.this,MainMenu.class);
                in.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);

            }
        });


        b10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enableButtonOrDisable(true);

            }
        });
    }


    protected void enableButtonOrDisable(boolean b) {
        for(Button btn:buttonArr){
            btn.setText("");
            //	btn.setClickable(b);
            if(b){
                btn.setEnabled(true);
                count=0;
                btn.setBackgroundColor(Color.LTGRAY);
            }
            else{count=0;
                btn.setEnabled(false);
            }
        }

    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Button btn = (Button)v;
        buttonClicked(btn);

    }




    int count2=1;
    public void buttonClicked(Button btn) {
        // TODO Auto-generated method stub


        if(count2%2==0){

            btn.setText("x");
            btn.setBackgroundColor(Color.RED);
            checkForWinner();
            btn.setEnabled(false);
            Toast.makeText(getApplicationContext(), player2Name+" your turn", Toast.LENGTH_SHORT).show();
            count2++;
        }else{
            btn.setText("O");
            btn.setBackgroundColor(Color.YELLOW);
            checkForWinner();
            btn.setEnabled(false);
            Toast.makeText(getApplicationContext(), player1Name+" your turn", Toast.LENGTH_SHORT).show();

            count2++;
        }



    }

    public void resultWin1(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Result");
        builder1.setMessage("Congratulations "+ player1Name +" You Win");
        builder1.setCancelable(true);
        builder1.setNeutralButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
        count2=1;
    }
    public void resultWin2(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Result");
        builder1.setMessage("Congratulations "+ player2Name +" You Win");
        builder1.setCancelable(true);
        builder1.setNeutralButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
        count2=1;
    }
    public void resultDraw(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Result");
        builder1.setMessage("OOPS!!! Match Draw");
        builder1.setCancelable(true);
        builder1.setNeutralButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
        count2=1;
    }
    private void checkForWinner() {
        // TODO Auto-generated method stub
        count++;

        if ((b1.getText()=="O" && b2.getText()=="O")&&
                (b2.getText()=="O" && b3.getText()=="O")){
            resultWin2();
            //Toast.makeText(this, "computer win ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b4.getText()=="O" && b5.getText()=="O")&&
                (b6.getText()=="O" && b5.getText()=="O")){
            resultWin2();
            //Toast.makeText(this, "computer win", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b7.getText()=="O" && b8.getText()=="O")&&
                (b8.getText()=="O" && b9.getText()=="O")){
            resultWin2();
            //Toast.makeText(this, "computer win ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b1.getText()=="O" && b5.getText()=="O")&&
                (b9.getText()=="O" && b5.getText()=="O")){
            resultWin2();
            // Toast.makeText(this, "computer win ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b3.getText()=="O" && b5.getText()=="O")&&
                (b5.getText()=="O" && b7.getText()=="O")){
            resultWin2();
            // Toast.makeText(this, "computer win", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b1.getText()=="O" && b4.getText()=="O")&&
                (b4.getText()=="O" && b7.getText()=="O")){
            resultWin2();
            // Toast.makeText(this, "computer win", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b2.getText()=="O" && b5.getText()=="O")&&
                (b5.getText()=="O" && b8.getText()=="O")){
            resultWin2();
            // Toast.makeText(this, "computer win ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b3.getText()=="O" && b6.getText()=="O")&&
                (b6.getText()=="O" && b9.getText()=="O")){
            resultWin2();
            // Toast.makeText(this, "computer win  ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b1.getText()=="x" && b2.getText()=="x")&&
                (b2.getText()=="x" && b3.getText()=="x")){
            resultWin1();
            // Toast.makeText(this, "congratulation you win  ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b4.getText()=="x" && b5.getText()=="x")&&
                (b6.getText()=="x" && b5.getText()=="x")){
            resultWin1();
            // Toast.makeText(this, "congratulation you win  ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b7.getText()=="x" && b8.getText()=="x")&&
                (b8.getText()=="x" && b9.getText()=="x")){
            resultWin1();
            // Toast.makeText(this, "congratulation you win  ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b1.getText()=="x" && b5.getText()=="x")&&
                (b9.getText()=="x" && b5.getText()=="x")){
            resultWin1();
            // Toast.makeText(this, "congratulation you win  ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b3.getText()=="x" && b5.getText()=="x")&&
                (b5.getText()=="x" && b7.getText()=="x")){
            resultWin1();
            // Toast.makeText(this, "congratulation you win  ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b1.getText()=="x" && b4.getText()=="x")&&
                (b4.getText()=="x" && b7.getText()=="x")){
            resultWin1();
            // Toast.makeText(this, "congratulation you win  ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b2.getText()=="x" && b5.getText()=="x")&&
                (b5.getText()=="x" && b8.getText()=="x")){
            resultWin1();
            // Toast.makeText(this, "congratulation you win ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b3.getText()=="x" && b6.getText()=="x")&&
                (b6.getText()=="x" && b9.getText()=="x")){
            resultWin1();
            //Toast.makeText(this, "congratulation you win ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }

        if(count==9) {
            resultDraw();
            // Toast.makeText(this, "Match Draw ", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }


    }
}
