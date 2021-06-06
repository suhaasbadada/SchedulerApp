package com.example.schedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity8 extends AppCompatActivity {
    Button suhaas,ayush,bobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        suhaas = (Button) findViewById(R.id.button21);
        ayush = (Button) findViewById(R.id.button19);
        bobby = (Button) findViewById(R.id.button20);

        suhaas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/suhaas-badada/"));
                startActivity(browserIntent);
            }
        });

        ayush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/aayush-mantri-1b575b199/"));
                startActivity(browserIntent);
            }
        });

        bobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/aditya-chaudhary-71306b190/"));
                startActivity(browserIntent);
            }
        });




    }
}