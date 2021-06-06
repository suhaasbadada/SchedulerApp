package com.example.schedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    EditText n,processid,bursttime,fetchid;
    Button submit,fetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        n =(EditText) findViewById(R.id.editTextTextPersonName23);
        processid = (EditText) findViewById(R.id.editTextTextPersonName24);
        bursttime = (EditText) findViewById(R.id.editTextTextPersonName25);
        fetchid = (EditText) findViewById(R.id.editTextTextPersonName26);
        submit = (Button) findViewById(R.id.button15);
        fetch = (Button) findViewById(R.id.button16);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = n.getText().toString();
                String b = processid.getText().toString();
                String c = bursttime.getText().toString();



                int num = Integer.parseInt(a);


                String [] processids = b.split("\\s");
                String [] bursttimes = c.split("\\s");



                int [] pid = new int[num];
                int [] bt = new int[num];
                int [] wt = new int[num];
                int [] tat = new int[num];

                int i,j;
                double avwt=0.0,avtat=0.0;

                for(i=0;i<num;i++)
                {
                    pid[i] = Integer.parseInt(processids[i]);
                    bt[i] = Integer.parseInt(bursttimes[i]);

                }

                wt[0]=0;

                for( i=1;i<num;i++)
                {
                    wt[i]=0;
                    for(j=0;j<i;j++)
                        wt[i]+=bt[j];
                }


                for(i=0;i<num;i++)
                {
                    tat[i]=bt[i]+wt[i];
                    avwt+=wt[i];
                    avtat+=tat[i];

                }

                avwt/=num;
                avtat/=num;

                String at = String.format("%.2f",avtat);
                String awt = String.format("%.2f",avwt);


                Toast.makeText(MainActivity6.this, "Average Waiting time ="+awt+"|| Average Turnaround ="+ at, Toast.LENGTH_SHORT).show();



            }
        });


        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = n.getText().toString();
                String b = processid.getText().toString();
                String c = bursttime.getText().toString();
                String f = fetchid.getText().toString();



                int num = Integer.parseInt(a);
                int ff = Integer.parseInt(f);
                int check2 = 0;


                String [] processids = b.split("\\s");
                String [] bursttimes = c.split("\\s");



                int [] pid = new int[num];
                int [] bt = new int[num];
                int [] wt = new int[num];
                int [] tat = new int[num];

                int i,j;
                double avwt=0.0,avtat=0.0;

                for(i=0;i<num;i++)
                {
                    pid[i] = Integer.parseInt(processids[i]);
                    bt[i] = Integer.parseInt(bursttimes[i]);

                }

                wt[0]=0;

                for( i=1;i<num;i++)
                {
                    wt[i]=0;
                    for(j=0;j<i;j++)
                        wt[i]+=bt[j];
                }


                for(i=0;i<num;i++)
                {
                    tat[i]=bt[i]+wt[i];
                    avwt+=wt[i];
                    avtat+=tat[i];

                }

                for(int k=0;k<num;k++){
                    if(pid[k]==ff){
                        check2 =k;
                        break;
                    }
                }

                String btt = Integer.toString(bt[check2]);
                String t= Integer.toString(tat[check2]);
                String wtt = Integer.toString(wt[check2]);

                Toast.makeText(MainActivity6.this, " Waiting time ="+wtt + "|| Turnaround ="+ t+"|| Burst time ="+btt , Toast.LENGTH_SHORT).show();



            }
        });
    }
}