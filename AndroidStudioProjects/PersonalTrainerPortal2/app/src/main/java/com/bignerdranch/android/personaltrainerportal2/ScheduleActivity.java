package com.bignerdranch.android.personaltrainerportal2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        TextView textView = (TextView)findViewById(R.id.tvSessionSchd);
    }
}
