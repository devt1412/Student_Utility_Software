package com.example.studentutility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
CardView ttcard,gpacard;
ImageButton logoutbt;
TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttcard=findViewById(R.id.ttcard);
        gpacard=findViewById(R.id.gpacard);
        logoutbt=findViewById(R.id.logoutbt);
        hello=findViewById(R.id.hello);
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String name=user.getDisplayName();
        hello.setText("Hello, "+name.substring(0,name.indexOf(" ")));
        ttcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Timetable.class);
                startActivity(i);
                finish();
            }
        });
        gpacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,GPA.class);
                startActivity(i);
                finish();
            }
        });
        logoutbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}