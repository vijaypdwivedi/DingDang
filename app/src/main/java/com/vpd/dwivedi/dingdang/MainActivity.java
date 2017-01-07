package com.vpd.dwivedi.dingdang;

import java.util.HashSet;
import java.util.Iterator;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    Button []buttonArr;

    static int  count=0;
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
        for(Button btn : buttonArr){
            btn.setText("");
            btn.setOnClickListener(this);
        }

        b11.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,MainMenu.class);
                in.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);

            }
        });


        b10.setOnClickListener(new OnClickListener() {

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



    public void buttonClicked(Button btn) {
        // TODO Auto-generated method stub

        btn.setText("x");
        btn.setBackgroundColor(Color.RED);
        checkForWinner();
        btn.setEnabled(false);
        if(count!=0){


            androidMove();

        }

    }

    public void resultWin1(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Result");
        builder1.setMessage("Congratulations!! You Win");
        builder1.setCancelable(true);
        builder1.setNeutralButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
    public void resultWin2(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Result");
        builder1.setMessage("Oh!! Android Win \"You Lose\"");
        builder1.setCancelable(true);
        builder1.setNeutralButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

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

    }
    private void androidMove() {
        if((b5.getText()=="")){
            b5.setText("O");
            b5.setBackgroundColor(Color.YELLOW);
            b5.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b1.getText()=="O" && b5.getText()=="O")&& b9.getText()==""){
            b9.setText("O");
            b9.setBackgroundColor(Color.YELLOW);
            b9.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b1.getText()=="O" && b9.getText()=="O")&& b5.getText()==""){
            b5.setText("O");
            b5.setBackgroundColor(Color.YELLOW);
            b5.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b9.getText()=="O" && b5.getText()=="O")&& b1.getText()==""){
            b1.setText("O");
            b1.setBackgroundColor(Color.YELLOW);
            b1.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b3.getText()=="O" && b5.getText()=="O")&& b7.getText()==""){
            b7.setText("O");
            b7.setBackgroundColor(Color.YELLOW);
            b7.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b7.getText()=="O" && b5.getText()=="O")&& b3.getText()==""){
            b3.setText("O");
            b3.setBackgroundColor(Color.YELLOW);
            b3.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b3.getText()=="O" && b7.getText()=="O")&& b5.getText()==""){
            b5.setText("O");
            b5.setBackgroundColor(Color.YELLOW);
            b5.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();

        }
        else if((b7.getText()=="O" && b8.getText()=="O")&& b9.getText()==""){
            b9.setText("O");
            b9.setBackgroundColor(Color.YELLOW);
            b9.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b7.getText()=="O" && b9.getText()=="O")&& b8.getText()==""){
            b8.setText("O");
            b8.setBackgroundColor(Color.YELLOW);
            b8.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b8.getText()=="O" && b9.getText()=="O")&& b7.getText()==""){
            b5.setText("O");
            b5.setBackgroundColor(Color.YELLOW);
            b5.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b1.getText()=="O" && b2.getText()=="O")&& b3.getText()==""){
            b3.setText("O");
            b3.setBackgroundColor(Color.YELLOW);
            b3.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b2.getText()=="O" && b3.getText()=="O")&& b1.getText()==""){
            b1.setText("O");
            b1.setBackgroundColor(Color.YELLOW);
            b1.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b1.getText()=="O" && b3.getText()=="O")&& b2.getText()==""){
            b2.setText("O");
            b2.setBackgroundColor(Color.YELLOW);
            b2.setEnabled(false);
            checkForWinner();
            //  Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b6.getText()=="O" && b5.getText()=="O")&& b4.getText()==""){
            b4.setText("O");
            b4.setBackgroundColor(Color.YELLOW);
            b4.setEnabled(false);
            checkForWinner();
            //Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b4.getText()=="O" && b6.getText()=="O")&& b5.getText()==""){
            b5.setText("O");
            b5.setBackgroundColor(Color.YELLOW);
            b5.setEnabled(false);
            checkForWinner();
            //Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b1.getText()=="O" && b5.getText()=="O")&& b6.getText()==""){
            b6.setText("O");
            b6.setBackgroundColor(Color.YELLOW);
            b6.setEnabled(false);
            checkForWinner();
            //Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b1.getText()=="O" && b5.getText()=="O")&& b9.getText()==""){
            b9.setText("O");
            b9.setBackgroundColor(Color.YELLOW);
            b9.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b4.getText()=="O" && b7.getText()=="O")&& b1.getText()==""){
            b1.setText("O");
            b1.setBackgroundColor(Color.YELLOW);
            b1.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b1.getText()=="O" && b7.getText()=="O")&& b4.getText()==""){
            b4.setText("O");
            b4.setBackgroundColor(Color.YELLOW);
            b4.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b1.getText()=="O" && b4.getText()=="O")&& b7.getText()==""){
            b7.setText("O");
            b7.setBackgroundColor(Color.YELLOW);
            b7.setEnabled(false);
            checkForWinner();
            //  Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b5.getText()=="O" && b8.getText()=="O")&& b2.getText()==""){
            b2.setText("O");
            b2.setBackgroundColor(Color.YELLOW);
            b2.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b2.getText()=="O" && b8.getText()=="O")&& b5.getText()==""){
            b5.setText("O");
            b5.setBackgroundColor(Color.YELLOW);
            b5.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b2.getText()=="O" && b5.getText()=="O")&& b8.getText()==""){
            b8.setText("O");
            b8.setBackgroundColor(Color.YELLOW);
            b8.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b6.getText()=="O" && b9.getText()=="O")&& b3.getText()==""){
            b3.setText("O");
            b3.setBackgroundColor(Color.YELLOW);
            b3.setEnabled(false);
            checkForWinner();
            //  Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b3.getText()=="O" && b9.getText()=="O")&& b6.getText()==""){
            b6.setText("O");
            b6.setBackgroundColor(Color.YELLOW);
            b6.setEnabled(false);
            checkForWinner();
            //Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b3.getText()=="O" && b6.getText()=="O")&& b9.getText()==""){
            b9.setText("O");
            b9.setBackgroundColor(Color.YELLOW);
            b9.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }else if((b5.getText()=="x")&&( b1.getText()==""&&b3.getText()==""&&
                b7.getText()==""&& b9.getText()=="")){
            HashSet<Button> ts = new HashSet<Button>();
            ts.add(b1);ts.add(b3);ts.add(b7);ts.add(b9);
            Iterator<Button>itr= ts.iterator();
            Button b=(Button)itr.next();
            b.setText("O");
            b.setBackgroundColor(Color.YELLOW);
            b.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();

        }
        else if((b1.getText()=="") &&((b2.getText()=="x" && b3.getText()=="x")||
                (b5.getText()=="x"&& b9.getText()=="x")||
                (b4.getText()=="x" && b7.getText()=="x")))
        {
            b1.setText("O");
            b1.setBackgroundColor(Color.YELLOW);
            b1.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b2.getText()=="") &&((b1.getText()=="x" && b3.getText()=="x")||
                (b5.getText()=="x"&& b8.getText()=="x"))){
            b2.setText("O");
            b2.setBackgroundColor(Color.YELLOW);
            b2.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b3.getText()=="") &&((b6.getText()=="x" && b9.getText()=="x")||
                (b5.getText()=="x"&& b7.getText()=="x")||
                (b1.getText()=="x" && b2.getText()=="x")))
        {b3.setText("O");
            b3.setBackgroundColor(Color.YELLOW);
            b3.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b4.getText()=="") &&((b1.getText()=="x" && b7.getText()=="x")||
                (b5.getText()=="x"&& b6.getText()=="x"))){
            b4.setText("O");
            b4.setBackgroundColor(Color.YELLOW);
            b4.setEnabled(false);
            checkForWinner();
            //  Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();

        }else if((b6.getText()=="") &&((b3.getText()=="x" && b9.getText()=="x")||
                (b4.getText()=="x"&& b5.getText()=="x"))){
            b6.setText("O");
            b6.setBackgroundColor(Color.YELLOW);
            b6.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b8.getText()=="") &&((b7.getText()=="x" && b9.getText()=="x")||
                (b2.getText()=="x"&& b5.getText()=="x"))){
            b8.setText("O");
            b8.setBackgroundColor(Color.YELLOW);
            b8.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b7.getText()=="") &&((b1.getText()=="x" && b4.getText()=="x")||
                (b8.getText()=="x"&& b9.getText()=="x")||
                (b3.getText()=="x" && b5.getText()=="x")))
        {b7.setText("O");
            b7.setBackgroundColor(Color.YELLOW);
            b7.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b9.getText()=="") &&((b1.getText()=="x" && b5.getText()=="x")||
                (b7.getText()=="x"&& b8.getText()=="x")||
                (b3.getText()=="x" && b6.getText()=="x")))
        {b9.setText("O");
            b9.setBackgroundColor(Color.YELLOW);
            b9.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b5.getText()=="") &&((b1.getText()=="x" && b9.getText()=="x")||
                (b3.getText()=="x"&& b7.getText()=="x")||
                (b4.getText()=="x" && b6.getText()=="x")||
                (b2.getText()=="x" && b8.getText()=="x")))
        {b5.setText("O");
            b5.setBackgroundColor(Color.YELLOW);
            b5.setEnabled(false);
            checkForWinner();
            // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
        }
        else if((b4.getText()=="x" && b2.getText()=="x")||
                (b2.getText()=="x"&& b6.getText()=="x")||
                (b4.getText()=="x" && b8.getText()=="x")||
                (b6.getText()=="x" && b8.getText()=="x")||
                (b6.getText()=="x" && b4.getText()=="x")||
                (b2.getText()=="x" && b8.getText()=="x")||
                (b1.getText()=="x" && b6.getText()=="x")||
                (b3.getText()=="x" && b4.getText()=="x")||
                (b1.getText()=="x" && b8.getText()=="x")||
                (b3.getText()=="x" && b8.getText()=="x")||
                (b3.getText()=="x" && b7.getText()=="x")||
                (b1.getText()=="x" && b9.getText()=="x")||
                (b2.getText()=="x" && b7.getText()=="x")||
                (b2.getText()=="x" && b9.getText()=="x")||
                (b4.getText()=="x" && b9.getText()=="x")||
                (b6.getText()=="x" && b7.getText()=="x")||
                (b5.getText()=="x" && b7.getText()=="x")||
                (b3.getText()=="x" && b5.getText()=="x")||
                (b1.getText()=="x" && b5.getText()=="x")||
                (b5.getText()=="x" && b9.getText()=="x"))
        {

            if((b1.getText()=="" )){
                b1.setText("O");
                b1.setBackgroundColor(Color.YELLOW);
                b1.setEnabled(false);
                checkForWinner();
                // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();

            }
            else if((b2.getText()=="" )){
                b2.setText("O");
                b2.setBackgroundColor(Color.YELLOW);
                b2.setEnabled(false);
                checkForWinner();
                // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();

            }
            else if((b3.getText()=="" )){
                b3.setText("O");
                b3.setBackgroundColor(Color.YELLOW);
                b3.setEnabled(false);
                checkForWinner();
                //Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
            }
            else if((b4.getText()=="" )){
                b4.setText("O");
                b4.setBackgroundColor(Color.YELLOW);
                b4.setEnabled(false);
                checkForWinner();
                // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
            }
            else if((b5.getText()=="" )){
                b5.setText("O");
                b5.setBackgroundColor(Color.YELLOW);
                b5.setEnabled(false);
                checkForWinner();
                // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
            }
            else if((b6.getText()=="" )){
                b6.setText("O");
                b6.setBackgroundColor(Color.YELLOW);
                b6.setEnabled(false);
                checkForWinner();
                // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
            }
            else if((b7.getText()=="" )){
                b7.setText("O");
                b7.setBackgroundColor(Color.YELLOW);
                b7.setEnabled(false);
                checkForWinner();
                //Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
            }
            else if((b8.getText()=="" )){
                b8.setText("O");
                b8.setBackgroundColor(Color.YELLOW);
                b8.setEnabled(false);
                checkForWinner();
                // Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
            }
            else if((b9.getText()=="" )){
                b9.setText("O");
                b9.setBackgroundColor(Color.YELLOW);
                b9.setEnabled(false);
                checkForWinner();
                //Toast.makeText(getApplicationContext(), "Your Turn", Toast.LENGTH_SHORT).show();
            }

        }
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
            // Toast.makeText(this, "computer win", Toast.LENGTH_LONG).show();
            enableButtonOrDisable(false);
        }
        else if ((b7.getText()=="O" && b8.getText()=="O")&&
                (b8.getText()=="O" && b9.getText()=="O")){
            resultWin2();
            // Toast.makeText(this, "computer win ", Toast.LENGTH_LONG).show();
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
            //Toast.makeText(this, "computer win", Toast.LENGTH_LONG).show();
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
