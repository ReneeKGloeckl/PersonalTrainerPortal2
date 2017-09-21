package com.bignerdranch.android.personaltrainerportal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ClientActivity extends AppCompatActivity implements TextWatcher{
    private static final String TAG = "ClientActivity";

    EditText name;
    EditText address;
    EditText phone;
    CheckBox cbA, cbI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        Log.d(TAG, "onCreate: Starting");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        name = (EditText)findViewById(R.id.ETname);
        name.addTextChangedListener(this);
        address = (EditText)findViewById(R.id.ETaddress);
        address.addTextChangedListener(this);
        phone = (EditText)findViewById(R.id.ETphone);
        phone.addTextChangedListener(this);

        Button btnNavList = (Button) findViewById(R.id.btnSave);
        btnNavList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: btnNavList");

                Intent intent = new Intent(ClientActivity.this,ClientListActivity.class );
                startActivity(intent);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
