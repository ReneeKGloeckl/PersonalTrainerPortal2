package com.bignerdranch.android.personaltrainerportal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainPortalActivity extends AppCompatActivity {

    private static final String TAG = "MainPortalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_portal);
        Log.d(TAG, "onCreate: Starting");


        UserFragment portalFragment = new UserFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, portalFragment).commit();

        ImageView imageView = (ImageView)findViewById(R.id.logoImage);

        Button btnNavNewClient = (Button) findViewById(R.id.btnNewClient);
        btnNavNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked btnNavNewClient");
                Intent intent = new Intent(MainPortalActivity.this, ClientActivity.class);
                startActivity(intent);
            }
        });

        Button btnNavClist = (Button)findViewById(R.id.btnClist);
        btnNavClist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked btnNavClist");
                Intent intent = new Intent(MainPortalActivity.this, ClientListActivity.class);
                startActivity(intent);
            }
        });

        Button btnNavPayment = (Button)findViewById(R.id.btnPayment);
        btnNavPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked btnNavPayment");
                Intent intent = new Intent(MainPortalActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });

        Button btnNavSchedule = (Button)findViewById(R.id.btnSchedule);
        btnNavSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked btnNavSchedule");
                Intent intent = new Intent(MainPortalActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.logOff){
            Toast.makeText(this,"Logging you off",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, LoginActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }
}

