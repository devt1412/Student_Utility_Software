package com.example.studentutility;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Timetable extends AppCompatActivity {
CardView addbt,a1,a2,b1,b2,c1,c2,next;
EditText sname;
Boolean select=false,sa1=true,sa2=true,sb1=true,sb2=true,sc1=true,sc2=true;
String sl="";
int count=0;
TextView t1,t2,t3;
ImageButton backbt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        addbt=findViewById(R.id.addbt);
        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        t1=findViewById(R.id.firstsub);
        t2=findViewById(R.id.secondsub);
        t3=findViewById(R.id.thirdsub);
        sname=findViewById(R.id.sname);
        next=findViewById(R.id.nextbt);

        backbt1=findViewById(R.id.backbt1);


        backbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Timetable.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sa1){
                    select=true;
                    sa1=false;
                    sl=sl+"A1";
                    a1.getBackground().setTint(Color.rgb(255,3,218));
                }
                else{
                    Toast.makeText(Timetable.this,"Slot already chosen",Toast.LENGTH_SHORT).show();
                }

            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sa2){
                    select=true;
                    sa2=false;
                    sl=sl+"A2";
                    a2.getBackground().setTint(Color.rgb(255,3,218));
                }
                else{
                    Toast.makeText(Timetable.this,"Slot already chosen",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb1){
                    select=true;
                    sb1=false;
                    sl=sl+"B1";
                    b1.getBackground().setTint(Color.rgb(255,3,218));
                }
                else{
                    Toast.makeText(Timetable.this,"Slot already chosen",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb2){
                    select=true;
                    sb2=false;
                    sl=sl+"B2";
                    b2.getBackground().setTint(Color.rgb(255,3,218));
                }
                else{
                    Toast.makeText(Timetable.this,"Slot already chosen",Toast.LENGTH_SHORT).show();
                }
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sc1){
                    select=true;
                    sc1=false;
                    sl=sl+"C1";
                    c1.getBackground().setTint(Color.rgb(255,3,218));
                }
                else{
                    Toast.makeText(Timetable.this,"Slot already chosen",Toast.LENGTH_SHORT).show();
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sc2){
                    select=true;
                    sc2=false;
                    sl=sl+"C2";
                    c2.getBackground().setTint(Color.rgb(255,3,218));
                }
                else{
                    Toast.makeText(Timetable.this,"Slot already chosen",Toast.LENGTH_SHORT).show();
                }
            }
        });
        addbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sname.getText().toString().length()>0 && select==true && count<4) {
                    if(t1.getText().toString().contains(sname.getText().toString().trim()) ||t2.getText().toString().contains(sname.getText().toString().trim())||t3.getText().toString().contains(sname.getText().toString().trim()) ){
                        sname.setError("Subject already chosen");
                    }
                    else {
                        count++;
                        if (count == 1) {
                            t1.setText("1." + sname.getText().toString() + " (" + sl + ")");
                            sl = "";
                        } else if (count == 2) {
                            t2.setText("2." + sname.getText().toString() + " (" + sl + ")");
                            sl = "";
                        } else if (count == 3) {
                            t3.setText("3." + sname.getText().toString() + " (" + sl + ")");
                            sl = "";
                        }
                        sname.setText("");
                        select = false;
                        Toast.makeText(Timetable.this, "Subject added", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(sname.getText().toString().length()==0){
                    sname.setError("Can't be empty");
                }
                else if(select==false){
                    Toast.makeText(Timetable.this, "Slot not selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t3.getText().toString().length()>3){
                Intent i=new Intent(Timetable.this,TTDisplay.class);
                String sub1=t1.getText().toString().substring(2,t1.getText().toString().indexOf('('));
                String sub2=t2.getText().toString().substring(2,t2.getText().toString().indexOf('('));
                String sub3=t3.getText().toString().substring(2,t3.getText().toString().indexOf('('));
                String sl1=t1.getText().toString().substring(t1.getText().toString().indexOf('(')+1,t1.getText().toString().indexOf(')'));
                String sl2=t2.getText().toString().substring(t2.getText().toString().indexOf('(')+1,t2.getText().toString().indexOf(')'));
                String sl3=t3.getText().toString().substring(t3.getText().toString().indexOf('(')+1,t3.getText().toString().indexOf(')'));
                String subjects[]={sub1,sub2,sub3};
                String slots[]={sl1,sl2,sl3};
                i.putExtra("sub",subjects);
                i.putExtra("slo",slots);
                startActivity(i);
                finish();}
                else{
                    Toast.makeText(Timetable.this,"Empty slots",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}