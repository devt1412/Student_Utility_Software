package com.example.studentutility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TTDisplay extends AppCompatActivity {
TextView a11,a12,a13,a14,a15,b11,b12,b13,b14,b15,c11,c12,c13,c14,c15,a21,a22,a23,a24,a25,b21,b22,b23,b24,b25,c21,c22,c23,c24,c25;
    ImageButton backbt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttdisplay);
        a11=findViewById(R.id.a11);
        a12=findViewById(R.id.a12);
        a13=findViewById(R.id.a13);
        a14=findViewById(R.id.a14);
        a15=findViewById(R.id.a15);
        b11=findViewById(R.id.b11);
        b12=findViewById(R.id.b12);
        b13=findViewById(R.id.b13);
        b14=findViewById(R.id.b14);
        b15=findViewById(R.id.b15);
        c11=findViewById(R.id.c11);
        c12=findViewById(R.id.c12);
        c13=findViewById(R.id.c13);
        c14=findViewById(R.id.c14);
        c15=findViewById(R.id.c15);
        a21=findViewById(R.id.a21);
        a22=findViewById(R.id.a22);
        a23=findViewById(R.id.a23);
        a24=findViewById(R.id.a24);
        a25=findViewById(R.id.a25);
        b21=findViewById(R.id.b21);
        b22=findViewById(R.id.b22);
        b23=findViewById(R.id.b23);
        b24=findViewById(R.id.b24);
        b25=findViewById(R.id.b25);
        c21=findViewById(R.id.c21);
        c22=findViewById(R.id.c22);
        c23=findViewById(R.id.c23);
        c24=findViewById(R.id.c24);
        c25=findViewById(R.id.c25);
        String subjects[]=getIntent().getStringArrayExtra("sub");
        String slots[]=getIntent().getStringArrayExtra("slo");
        backbt3=findViewById(R.id.backbt3);
        backbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TTDisplay.this,Timetable.class);
                startActivity(i);
                finish();
            }
        });

for(int i=0;i<3;i++){
    if(slots[i].equals("A1")) {
        a11.setText(subjects[i] + " " + slots[i]);
        a12.setText(subjects[i] + " " + slots[i]);
        a13.setText(subjects[i] + " " + slots[i]);
        a14.setText(subjects[i] + " " + slots[i]);
        a15.setText(subjects[i] + " " + slots[i]);
    }
    else if(slots[i].equals("B1")){
        b11.setText(subjects[i] + " " + slots[i]);
        b12.setText(subjects[i] + " " + slots[i]);
        b13.setText(subjects[i] + " " + slots[i]);
        b14.setText(subjects[i] + " " + slots[i]);
        b15.setText(subjects[i] + " " + slots[i]);
    }
    else if(slots[i].equals("C1")){
        c11.setText(subjects[i] + " " + slots[i]);
        c12.setText(subjects[i] + " " + slots[i]);
        c13.setText(subjects[i] + " " + slots[i]);
        c14.setText(subjects[i] + " " + slots[i]);
        c15.setText(subjects[i] + " " + slots[i]);
    }
    else if(slots[i].equals("A2")){
        a21.setText(subjects[i] + " " + slots[i]);
        a22.setText(subjects[i] + " " + slots[i]);
        a23.setText(subjects[i] + " " + slots[i]);
        a24.setText(subjects[i] + " " + slots[i]);
        a25.setText(subjects[i] + " " + slots[i]);
    }
    else if(slots[i].equals("B2")){
        b21.setText(subjects[i] + " " + slots[i]);
        b22.setText(subjects[i] + " " + slots[i]);
        b23.setText(subjects[i] + " " + slots[i]);
        b24.setText(subjects[i] + " " + slots[i]);
        b25.setText(subjects[i] + " " + slots[i]);
    }
    else if(slots[i].equals("C2")){
        c21.setText(subjects[i] + " " + slots[i]);
        c22.setText(subjects[i] + " " + slots[i]);
        c23.setText(subjects[i] + " " + slots[i]);
        c24.setText(subjects[i] + " " + slots[i]);
        c25.setText(subjects[i] + " " + slots[i]);
    }
}

            }

    }
