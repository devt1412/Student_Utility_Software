package com.example.studentutility;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Register extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText etemail,etpassword,firstname,surname;
    Button signupbt;
    ProgressBar progress;
    TextView loginhere;
    Boolean passwordVisible=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();
        etemail=findViewById(R.id.email);
        loginhere=findViewById(R.id.loginhere);
        etpassword=findViewById(R.id.password);
        signupbt=findViewById(R.id.btsignup);
        progress=findViewById(R.id.progress);
        firstname=findViewById(R.id.firstname);
        surname=findViewById(R.id.surname);
        etemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!Patterns.EMAIL_ADDRESS.matcher(etemail.getText().toString().trim()).matches()){
                    etemail.setError("Enter a valid email address");
                }
                else if(!etemail.getText().toString().contains("@vitstudent.ac.in")){
                    etemail.setError("Login through university email");
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etemail.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                if (email.isEmpty()) {
                    etemail.setError("Email can't be empty");
                } else if (password.isEmpty()) {
                    etpassword.setError("Password can't be empty");
                }
                else if(!etemail.getText().toString().contains("@vitstudent.ac.in")){
                    etemail.setError("Login through university email");
                }
                else if(firstname.getText().toString().length()==0){
                    firstname.setError("Can't be empty");
                }
                else if(surname.getText().toString().length()==0){
                    surname.setError("Can't be empty");
                }
                else {
                    progress.setVisibility(View.VISIBLE);
                    signupbt.setVisibility(View.INVISIBLE);
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(firstname.getText().toString()+" "+surname.getText().toString())
                                                .build();

                                        user.updateProfile(profileUpdates)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(Register.this, "Profile created", Toast.LENGTH_SHORT).show();
                                                            Intent i = new Intent(Register.this, MainActivity.class);
                                                            startActivity(i);
                                                            finish();
                                                        }
                                                        else{
                                                            Toast.makeText(Register.this, "Registration unsuccessful", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });


                                    } else {

                                        progress.setVisibility(View.INVISIBLE);
                                        signupbt.setVisibility(View.VISIBLE);
                                        Toast.makeText(Register.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            }
        });
        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Register.this,Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}