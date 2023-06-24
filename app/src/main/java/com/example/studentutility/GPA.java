package com.example.studentutility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GPA extends AppCompatActivity {
ImageButton refreshbt;
CardView addgpa;
Spinner grade,credit;
float gpa,totalc;
String g,c;
TextView gpat,subs;
int count=0;
    ImageButton backbt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        refreshbt=findViewById(R.id.refreshbt);
        addgpa=findViewById(R.id.addgpa);
        grade=findViewById(R.id.grade);
        credit=findViewById(R.id.credit);
        gpat=findViewById(R.id.gpa);
        subs=findViewById(R.id.subs);
        backbt2=findViewById(R.id.backbt2);

        ArrayAdapter<CharSequence> adapterc =ArrayAdapter.createFromResource(this,R.array.credit_array, R.layout.spin_color);
        adapterc.setDropDownViewResource(R.layout.spin_drop);
        ArrayAdapter<CharSequence> adapterg =ArrayAdapter.createFromResource(this,R.array.grade_array, R.layout.spin_color);
        adapterg.setDropDownViewResource(R.layout.spin_drop);
        adapterc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        credit.setAdapter(adapterc);
        grade.setAdapter(adapterg);

        credit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                c=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                c=adapterView.getItemAtPosition(0).toString();
            }
        });
        grade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                g=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                g=adapterView.getItemAtPosition(0).toString();
            }
        });

        backbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(GPA.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        addgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gpa=gpa*totalc;
                count=count+1;
                if(g.equals("S")){
                    totalc=totalc+Float.parseFloat(c);
                    gpa=(gpa+(Float.parseFloat(c)*10))/totalc;
                } else if (g.equals("A")) {
                    totalc=totalc+Float.parseFloat(c);
                    gpa=(gpa+(Float.parseFloat(c)*9))/totalc;

                }
                else if(g.equals("B")){
                    totalc=totalc+Float.parseFloat(c);
                    gpa=(gpa+(Float.parseFloat(c)*8))/totalc;
                }
                else if(g.equals("C")){
                    totalc=totalc+Float.parseFloat(c);
                    gpa=(gpa+(Float.parseFloat(c)*7))/totalc;
                }
                else if(g.equals("D")){
                    totalc=totalc+Float.parseFloat(c);
                    gpa=(gpa+(Float.parseFloat(c)*6))/totalc;
                }
                else if(g.equals("E")){
                    totalc=totalc+Float.parseFloat(c);
                    gpa=(gpa+(Float.parseFloat(c)*5))/totalc;
                }
                else if(g.equals("F")){
                    totalc=totalc+Float.parseFloat(c);
                    gpa=(gpa+(Float.parseFloat(c)*0))/totalc;
                }
                gpat.setText("GPA: "+gpa);
                subs.setText(subs.getText().toString()+"\n"+count+". "+g+"("+c+")");
            }
        });
        refreshbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalc=0;
                gpa=0;
                gpat.setText("0.00");
                count=0;
                subs.setText("Subjects:");
            }
        });

    }
}