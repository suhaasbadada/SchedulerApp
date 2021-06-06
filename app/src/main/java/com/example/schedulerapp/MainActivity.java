package com.example.schedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pre,pre1,pre2,pre3,fcfs,nb_pbrr,appinfo,aboutus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pre = (Button) findViewById(R.id.button);
        pre1 = (Button) findViewById(R.id.button2);
        pre2 = (Button) findViewById(R.id.button3);
        pre3 = (Button) findViewById(R.id.button4);
        fcfs = (Button) findViewById(R.id.button5);
        nb_pbrr = (Button) findViewById(R.id.button6);
        appinfo = (Button) findViewById(R.id.button22);
        aboutus = (Button) findViewById(R.id.button23);

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        pre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        pre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        pre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });


        fcfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });


        nb_pbrr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });

        appinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity9();
            }
        });


        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });






    }

    public void openActivity2(){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent=new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent=new Intent(this,MainActivity4.class);
        startActivity(intent);
    }

    public void openActivity5(){
        Intent intent=new Intent(this,MainActivity5.class);
        startActivity(intent);
    }

    public void openActivity6(){
        Intent intent=new Intent(this,MainActivity6.class);
        startActivity(intent);
    }

    public void openActivity7(){
        Intent intent=new Intent(this,MainActivity7.class);
        startActivity(intent);
    }

    public void openActivity8(){
        Intent intent=new Intent(this,MainActivity8.class);
        startActivity(intent);
    }

    public void openActivity9(){
        Intent intent=new Intent(this,MainActivity9.class);
        startActivity(intent);
    }



}