package com.example.studentutility;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText etloginmail,etloginpass;
    Button btlogin;
    TextView signuphere,forgot;
    FirebaseAuth mAuth;
    ProgressBar progress2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etloginmail=findViewById(R.id.logemail);
        etloginpass=findViewById(R.id.logpassword);
        btlogin=findViewById(R.id.btlogin);
        signuphere=findViewById(R.id.signuphere);
        progress2=findViewById(R.id.progress2);
        forgot=findViewById(R.id.forgot);

        mAuth=FirebaseAuth.getInstance();
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etloginmail.getText().toString().trim();
                String password = etloginpass.getText().toString().trim();
                if (email.equals("")) {
                    etloginmail.setError("Can't be empty");
                } else if (password.equals("")) {
                    etloginpass.setError("Can't be empty");
                } else {
                    progress2.setVisibility(View.VISIBLE);
                    btlogin.setVisibility(View.INVISIBLE);
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Login.this, MainActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
                                progress2.setVisibility(View.INVISIBLE);
                                btlogin.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }
        });

        signuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Login.this,Register.class);
                startActivity(i);
                finish();
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etloginmail.getText().toString().length() > 0 && etloginmail.getText().toString().contains("@") && etloginmail.getText().toString().contains(".")) {
                    FirebaseAuth.getInstance().sendPasswordResetEmail(etloginmail.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Login.this, "Email sent", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(Login.this, "Try again with existing account", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else if(etloginmail.getText().toString().length()== 0)
                {
                    etloginmail.setError("Can't be empty");
                }
                else if(!etloginmail.getText().toString().contains("@") || !etloginmail.getText().toString().contains("."))
                {
                    etloginmail.setError("Enter valid email");
                }

            }
        });
    }
}