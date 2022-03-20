package com.example.talonview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    public Button loginBTN, signUpBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        loginBTN = findViewById(R.id.loginWel);
        signUpBTN = findViewById(R.id.signUpWel);
        Intent login = new Intent(this, Login.class);
        Intent signUp = new Intent(this, SignUp.class);
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(login);
                overridePendingTransition(R.anim.slideright, R.anim.slideleft);
            }
        });
        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(signUp);
                overridePendingTransition(R.anim.slideright, R.anim.slideleft);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideleft, R.anim.slideright);
    }
}