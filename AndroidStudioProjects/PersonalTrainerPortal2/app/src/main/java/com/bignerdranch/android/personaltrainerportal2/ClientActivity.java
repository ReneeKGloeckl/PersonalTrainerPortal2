package com.bignerdranch.android.personaltrainerportal2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClientActivity extends AppCompatActivity {
    private static final String TAG = "ClientActivity";

    EditText NewName, NewAddress, NewPhone;
    Button btnSave, btnViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        NewName = (EditText) findViewById(R.id.etName);
        NewAddress = (EditText) findViewById(R.id.etAddress);
        NewPhone = (EditText) findViewById(R.id.etPhone);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cname = NewName.getText().toString();
                String caddress = NewAddress.getText().toString();
                String cphone = NewPhone.getText().toString();

                ContactsTable contactsTable = new ContactsTable(getApplicationContext());
                contactsTable.openDB();
                contactsTable.insertRecord(cname,caddress,cphone);
                Toast.makeText(getApplicationContext(),"Contact Saved",Toast.LENGTH_SHORT).show();
                contactsTable.closeDB();

                finish();

            }
        });

    }

}







