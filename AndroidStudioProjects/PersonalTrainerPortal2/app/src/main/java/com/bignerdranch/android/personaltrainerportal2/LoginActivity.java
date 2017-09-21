package com.bignerdranch.android.personaltrainerportal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button Blogin;
    EditText user;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.password);
        Blogin = (Button)findViewById(R.id.Blogin);

        Blogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (user.getText().toString().equals("jdoe") &&
                        password.getText().toString().equals("welcome1")){
                    //Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG);
                    Intent myintent = new Intent(LoginActivity.this, MainPortalActivity.class);
                    startActivity(myintent);
                }else
                    Toast.makeText(LoginActivity.this,R.string.unsuccessful_login,Toast.LENGTH_SHORT).show();
            }
        });

    }

}
