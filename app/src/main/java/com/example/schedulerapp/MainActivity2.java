package com.example.schedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText n,processid,bursttime,arrivaltime,priority,fetchid;
    Button submit,fetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        n =(EditText) findViewById(R.id.editTextTextPersonName7);
        processid = (EditText) findViewById(R.id.editTextTextPersonName8);
        bursttime = (EditText) findViewById(R.id.editTextTextPersonName9);
        arrivaltime = (EditText) findViewById(R.id.editTextTextPersonName10);
        priority = (EditText) findViewById(R.id.editTextTextPersonName11);
        fetchid = (EditText) findViewById(R.id.editTextTextPersonName12);
        submit = (Button) findViewById(R.id.button9);
        fetch = (Button) findViewById(R.id.button10);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = n.getText().toString();
                String b = processid.getText().toString();
                String c = bursttime.getText().toString();
                String d = arrivaltime.getText().toString();
                String e = priority.getText().toString();


                int num = Integer.parseInt(a);


                String [] processids = b.split("\\s");
                String [] bursttimes = c.split("\\s");
                String [] arrivaltimes = d.split("\\s");
                String [] priorities  = e.split("\\s");

                int [] pid = new int[num];
                int [] bt = new int[num];
                int [] at = new int[num];
                int [] pri = new int[num];
                int [] flag = new int[num];
                int [] wt_fac = new int[num];
                int [] og_burst = new int[num];

                int tc,i;

                for(i=0;i<num;i++)
                {
                    pid[i] = Integer.parseInt(processids[i]);
                    bt[i] = Integer.parseInt(bursttimes[i]);
                    at[i] = Integer.parseInt(arrivaltimes[i]);
                    pri[i] = Integer.parseInt(priorities[i]);
                    flag[i] = 0;
                    wt_fac[i] = (pri[i]*8)+(bt[i]*7)+(at[i]*2);
                    og_burst[i] =bt[i];

                }

                tc =at[0];
                int ti_q = tc;
                rr(num,bt,ti_q,at,wt_fac,pid,flag,og_burst);








            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = n.getText().toString();
                String b = processid.getText().toString();
                String c = bursttime.getText().toString();
                String d = arrivaltime.getText().toString();
                String e = priority.getText().toString();
                String f = fetchid.getText().toString();

                int num = Integer.parseInt(a);
                int ff = Integer.parseInt(f);

                String [] processids = b.split("\\s");
                String [] bursttimes = c.split("\\s");
                String [] arrivaltimes = d.split("\\s");
                String [] priorities  = e.split("\\s");

                int [] pid = new int[num];
                int [] bt = new int[num];
                int [] at = new int[num];
                int [] pri = new int[num];
                int [] flag = new int[num];
                int [] wt_fac = new int[num];
                int [] og_burst = new int[num];

                int tc,i;

                for(i=0;i<num;i++)
                {
                    pid[i] = Integer.parseInt(processids[i]);
                    bt[i] = Integer.parseInt(bursttimes[i]);
                    at[i] = Integer.parseInt(arrivaltimes[i]);
                    pri[i] = Integer.parseInt(priorities[i]);
                    flag[i] = 0;
                    wt_fac[i] = (pri[i]*8)+(bt[i]*7)+(at[i]*2);
                    og_burst[i] =bt[i];

                }

                tc =at[0];
                int ti_q = tc;
                rr2(num,bt,ti_q,at,wt_fac,pid,flag,og_burst,ff);








            }
        });

    }

    int time_q(int [] b,int num)
    {
        int tq=0;
        int count=0,i;
        for(i=0;i<num;i++)
        {
            if(b[i]>0)
            {
                tq+=b[i];
                count++;
            }
        }
        if(count>0)
        {
            tq=tq/count;
        }
        return tq;
    }

    void sort(int [] id,int [] wt,int [] b,int [] a,int nom,int [] ft,int [] ob,int [] com_t)
    {
        int i,j;
        int number=nom;
        for(i=0;i<number;i++)
        {
            for(j=i+1;j<number;j++)
            {
                if(wt[i]>wt[j])
                {
                    a[i]+=a[j];
                    a[j]=a[i]-a[j];
                    a[i]=a[i]-a[j];
                    id[i]+=id[j];
                    id[j]=id[i]-id[j];
                    id[i]=id[i]-id[j];
                    b[i]+=b[j];
                    b[j]=b[i]-b[j];
                    b[i]=b[i]-b[j];
                    ob[i]+=ob[j];
                    ob[j]=ob[i]-ob[j];
                    ob[i]=ob[i]-ob[j];
                    wt[i]+=wt[j];
                    wt[j]=wt[i]-wt[j];
                    wt[i]=wt[i]-wt[j];
                    ft[i]+=ft[j];
                    ft[j]=ft[i]-ft[j];
                    ft[i]=ft[i]-ft[j];
                    com_t[i]+=com_t[j];
                    com_t[j]=com_t[i]-com_t[j];
                    com_t[i]=com_t[i]-com_t[j];
                }
                else if(wt[i]==wt[j])
                {
                    if(id[i]>id[j])
                    {
                        a[i]+=a[j];
                        a[j]=a[i]-a[j];
                        a[i]=a[i]-a[j];
                        id[i]+=id[j];
                        id[j]=id[i]-id[j];
                        id[i]=id[i]-id[j];
                        b[i]+=b[j];
                        b[j]=b[i]-b[j];
                        b[i]=b[i]-b[j];
                        wt[i]+=wt[j];
                        wt[j]=wt[i]-wt[j];
                        wt[i]=wt[i]-wt[j];
                        ft[i]+=ft[j];
                        ft[j]=ft[i]-ft[j];
                        ft[i]=ft[i]-ft[j];
                        ob[i]+=ob[j];
                        ob[j]=ob[i]-ob[j];
                        ob[i]=ob[i]-ob[j];
                        com_t[i]+=com_t[j];
                        com_t[j]=com_t[i]-com_t[j];
                        com_t[i]=com_t[i]-com_t[j];
                    }
                }
            }
        }

    }

    void rr(int no,int [] burst,int time_quantum,int [] arr,int [] w,int [] p_id,int [] fla, int [] obt)
    {
        int i,j,time=time_quantum;
        int[] bur = new int[no];
        int []p = new int[no];
        int []art = new int[no];
        int []weight = new int[no];
        int num=0;
        int [] obr = new int[no];
        int [] ct= new int[no];
        int [] tat= new int[no];
        int [] wt= new int [no];
        double avg_tat=0.0,avg_wt=0.0;
        for(i=0;i<no;i++)
        {
            if(arr[i]<=time && fla[i]==0)
            {
                bur[i]=burst[i];
                obr[i]=obt[i];
                p[i]=p_id[i];
                weight[i]=w[i];
                art[i]=arr[i];
                fla[i]=1;
                ct[i]=0;
                num++;
            }
            else
                break;
        }
        time_quantum=time_q(bur,num);
        sort(p,weight,bur,art,num,fla,obr,ct);
        int counter=0,temp=0,la,solve=0;
        int k;
        while(counter<no)
        {
            for(k=0;k<num;k++)
            {

                if((bur[k]<=time_quantum) && (bur[k]>0))
                {

                    counter++;
                    time=time+bur[k];
                    bur[k]=0;
                    ct[k]=time;
                }
                else if(bur[k]>0)
                {
                    time=time+time_quantum;
                    int l;
                    for(l=0;l<num;l++)
                    {
                        if((bur[l]<=time_quantum-bur[k]) && (ct[l]==0) && (l!=k))
                        {
                            counter++;
                            time=time+bur[l];
                            bur[l]=0;
                            ct[l]=time;
                        }
                    }
                    bur[k]=bur[k]-time_quantum;

                }
            }
            int check=num;
            for(j=num;j<no;j++)
            {

                if((arr[j]<=time) && (fla[j]==0))
                {
                    bur[j]=burst[j];
                    obr[j]=obt[j];
                    p[j]=p_id[j];
                    weight[j]=w[j];
                    art[j]=arr[j];
                    fla[j]=1;
                    ct[j]=0;
                    check++;
                }
                else
                    break;
            }
            num=check;
            time_quantum=time_q(bur,num);
            sort(p,weight,bur,art,num,fla,obr,ct);
        }

        for(i=0;i<no;i++)
        {
            tat[i]=ct[i]-art[i];
            wt[i]=tat[i]-obr[i];
            avg_tat+=tat[i];
            avg_wt+=wt[i];

        }
        avg_tat=avg_tat/no;
        avg_wt=avg_wt/no;

        String at = String.format("%.2f",avg_tat);
        String awt = String.format("%.2f",avg_wt);


        Toast.makeText(MainActivity2.this, "Average Waiting time ="+awt+"||Average Turnaround ="+ at, Toast.LENGTH_SHORT).show();
    }


    void rr2(int no,int [] burst,int time_quantum,int [] arr,int [] w,int [] p_id,int [] fla, int [] obt,int fid)
    {
        int i,j,time=time_quantum;
        int[] bur = new int[no];
        int []p = new int[no];
        int []art = new int[no];
        int []weight = new int[no];
        int num=0;
        int [] obr = new int[no];
        int [] ct= new int[no];
        int [] tat= new int[no];
        int [] wt= new int [no];
        int f=fid;
        int check2=0;
        double avg_tat=0.0,avg_wt=0.0;
        for(i=0;i<no;i++)
        {
            if(arr[i]<=time && fla[i]==0)
            {
                bur[i]=burst[i];
                obr[i]=obt[i];
                p[i]=p_id[i];
                weight[i]=w[i];
                art[i]=arr[i];
                fla[i]=1;
                ct[i]=0;
                num++;
            }
            else
                break;
        }
        time_quantum=time_q(bur,num);
        sort(p,weight,bur,art,num,fla,obr,ct);
        int counter=0,temp=0,la,solve=0;
        int k;
        while(counter<no)
        {
            for(k=0;k<num;k++)
            {

                if((bur[k]<=time_quantum) && (bur[k]>0))
                {

                    counter++;
                    time=time+bur[k];
                    bur[k]=0;
                    ct[k]=time;
                }
                else if(bur[k]>0)
                {
                    time=time+time_quantum;
                    int l;
                    for(l=0;l<num;l++)
                    {
                        if((bur[l]<=time_quantum-bur[k]) && (ct[l]==0) && (l!=k))
                        {
                            counter++;
                            time=time+bur[l];
                            bur[l]=0;
                            ct[l]=time;
                        }
                    }
                    bur[k]=bur[k]-time_quantum;

                }
            }
            int check=num;
            for(j=num;j<no;j++)
            {

                if((arr[j]<=time) && (fla[j]==0))
                {
                    bur[j]=burst[j];
                    obr[j]=obt[j];
                    p[j]=p_id[j];
                    weight[j]=w[j];
                    art[j]=arr[j];
                    fla[j]=1;
                    ct[j]=0;
                    check++;
                }
                else
                    break;
            }
            num=check;
            time_quantum=time_q(bur,num);
            sort(p,weight,bur,art,num,fla,obr,ct);
        }

        for(i=0;i<no;i++)
        {
            tat[i]=ct[i]-art[i];
            wt[i]=tat[i]-obr[i];
            avg_tat+=tat[i];
            avg_wt+=wt[i];

        }
        avg_tat=avg_tat/no;
        avg_wt=avg_wt/no;

        for(i=0;i<no;i++){
            if(p[i]==f){
                check2 =i;
                break;
            }
        }

        String ctt = Integer.toString(ct[check2]);
        String t= Integer.toString(tat[check2]);
        String wtt = Integer.toString(wt[check2]);



        Toast.makeText(MainActivity2.this, " Waiting time ="+wtt + "|| Turnaround ="+ t+"|| Completion time ="+ctt , Toast.LENGTH_SHORT).show();


    }


}