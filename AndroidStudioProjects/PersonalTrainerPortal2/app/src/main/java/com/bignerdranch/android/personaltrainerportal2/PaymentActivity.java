package com.bignerdranch.android.personaltrainerportal2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {
    private static final String TAG = "PaymentActivity";

    TextView tv;
    EditText amount;
    EditText cardName;
    EditText cardNum;
    EditText exp;
    EditText cvv;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Log.d(TAG, "onCreate: Starting");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        tv = (TextView)findViewById(R.id.signIn);
        amount = (EditText) findViewById(R.id.ETamount);
        cardName = (EditText)findViewById(R.id.ETcardName);
        cardNum = (EditText)findViewById(R.id.ETcardNumber);
        exp = (EditText)findViewById(R.id.ETexp);
        cvv = (EditText)findViewById(R.id.ETcvv);
        email = (EditText)findViewById(R.id.ETemail);

        Button btnNavSubmit = (Button)findViewById(R.id.btnSubmit);
        btnNavSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked Submit");

            }
        });

    }
}
