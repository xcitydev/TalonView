package com.example.talonview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    TextView alreadyAct;
    private Button signUpBtn;
    private FirebaseAuth mAuth;
    private String email, password, confirmPassword;
    private EditText emailGet, passwordGet, confirmPasswordGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        signUpBtn = findViewById(R.id.lSignupBtn);
        alreadyAct = findViewById(R.id.alreadyAct);
        emailGet = findViewById(R.id.signUpMail);
        passwordGet = findViewById(R.id.signUpPassword);
        confirmPasswordGet = findViewById(R.id.signUpConfirmPassword);
        Intent alreadyAcct = new Intent(this, Login.class);
        alreadyAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(alreadyAcct);
                overridePendingTransition(R.anim.slideright, R.anim.slideleft);
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pas = passwordGet.getText().toString();
                String con = confirmPasswordGet.getText().toString();
               if (pas.equals(con)){
                   createUser();
               }else{
                   Toast.makeText(SignUp.this, "Password not correct", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.slideright, R.anim.slideleft);
    }
    public void createUser(){
        email = emailGet.getText().toString();
        password = passwordGet.getText().toString();
        confirmPassword = confirmPasswordGet.getText().toString();
        if (TextUtils.isEmpty(email)){
            emailGet.setError("Enter an email!");
        }else if (TextUtils.isEmpty(password)){
            passwordGet.setError("Password is empty");
        }else{
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Successfully signed in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this, Login.class));
                    }else if (task.isCanceled()){
                        Toast.makeText(getApplicationContext(), "Cancelled by user", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}