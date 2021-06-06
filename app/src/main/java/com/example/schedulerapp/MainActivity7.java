package com.example.schedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    EditText n,processid,bursttime,fetchid;
    Button submit,fetch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        n =(EditText) findViewById(R.id.editTextTextPersonName27);
        processid = (EditText) findViewById(R.id.editTextTextPersonName28);
        bursttime = (EditText) findViewById(R.id.editTextTextPersonName29);
        fetchid = (EditText) findViewById(R.id.editTextTextPersonName30);
        submit = (Button) findViewById(R.id.button17);
        fetch = (Button) findViewById(R.id.button18);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = n.getText().toString();
                String b = processid.getText().toString();
                String c = bursttime.getText().toString();



                int num = Integer.parseInt(a);
                int pos=0,temp=0,total=0;


                String [] processids = b.split("\\s");
                String [] bursttimes = c.split("\\s");



                int [] pid = new int[num];
                int [] bt = new int[num];
                int [] wt = new int[num];
                int [] tat = new int[num];
                int [] pr = new int[num];

                int i,j;
                double avwt=0.0,avtat=0.0;

                for(i=0;i<num;i++)
                {
                    pid[i] = Integer.parseInt(processids[i]);
                    bt[i] = Integer.parseInt(bursttimes[i]);

                }

                int tq=0;
                for(i=0;i<num;i++){
                    tq+=bt[i];
                }
                tq=tq/num;

                for(i=0;i<num;i++){
                    pr[i]=(bt[i]%tq);
                }

                for(i=0;i<num;i++)
                {
                    pos=i;
                    for(j=i+1;j<num;j++)
                    {
                        if(pr[j]<pr[pos])
                            pos=j;
                    }

                    temp=pr[i];
                    pr[i]=pr[pos];
                    pr[pos]=temp;

                    temp=bt[i];
                    bt[i]=bt[pos];
                    bt[pos]=temp;

                    temp=pid[i];
                    pid[i]=pid[pos];
                    pid[pos]=temp;
                }

                wt[0]=0;

                for(i=1;i<num;i++)
                {
                    wt[i]=0;
                    for(j=0;j<i;j++)
                        wt[i]+=bt[j];

                    total+=wt[i];
                }

                avwt=total/num;
                total=0;

                for(i=0;i<num;i++)
                {
                    tat[i]=bt[i]+wt[i];
                    total+=tat[i];
                }
                avtat=total/num;

                String at = String.format("%.2f",avtat);
                String awt = String.format("%.2f",avwt);


                Toast.makeText(MainActivity7.this, "Average Waiting time ="+awt+"|| Average Turnaround ="+ at, Toast.LENGTH_SHORT).show();



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
                int pos=0,temp=0,total=0;


                String [] processids = b.split("\\s");
                String [] bursttimes = c.split("\\s");



                int [] pid = new int[num];
                int [] bt = new int[num];
                int [] wt = new int[num];
                int [] tat = new int[num];
                int [] pr = new int[num];

                int i,j;
                double avwt=0.0,avtat=0.0;

                for(i=0;i<num;i++)
                {
                    pid[i] = Integer.parseInt(processids[i]);
                    bt[i] = Integer.parseInt(bursttimes[i]);

                }

                int tq=0;
                for(i=0;i<num;i++){
                    tq+=bt[i];
                }
                tq=tq/num;

                for(i=0;i<num;i++){
                    pr[i]=(bt[i]%tq);
                }

                for(i=0;i<num;i++)
                {
                    pos=i;
                    for(j=i+1;j<num;j++)
                    {
                        if(pr[j]<pr[pos])
                            pos=j;
                    }

                    temp=pr[i];
                    pr[i]=pr[pos];
                    pr[pos]=temp;

                    temp=bt[i];
                    bt[i]=bt[pos];
                    bt[pos]=temp;

                    temp=pid[i];
                    pid[i]=pid[pos];
                    pid[pos]=temp;
                }

                wt[0]=0;

                for(i=1;i<num;i++)
                {
                    wt[i]=0;
                    for(j=0;j<i;j++)
                        wt[i]+=bt[j];

                    total+=wt[i];
                }

                avwt=total/num;
                total=0;

                for(i=0;i<num;i++)
                {
                    tat[i]=bt[i]+wt[i];
                    total+=tat[i];
                }
                avtat=total/num;

                for(int k=0;k<num;k++){
                    if(pid[k]==ff){
                        check2 =k;
                        break;
                    }
                }

                String btt = Integer.toString(bt[check2]);
                String t= Integer.toString(tat[check2]);
                String wtt = Integer.toString(wt[check2]);
                String pri =Integer.toString(pr[check2]);

                Toast.makeText(MainActivity7.this, " Waiting time ="+wtt + "|| Turnaround ="+ t+"|| Burst time ="+btt + "||Calculated Priority =" + pri, Toast.LENGTH_SHORT).show();





            }
        });



    }
}