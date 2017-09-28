package com.bignerdranch.android.personaltrainerportal2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientActivity extends AppCompatActivity {
    private static final String TAG = "ClientActivity";
    private static int REQUEST_PHOTO = 1;

    EditText NewName, NewAddress, NewPhone;
    Button btnSave, btnCamera;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        NewName = (EditText) findViewById(R.id.etName);
        NewAddress = (EditText) findViewById(R.id.etAddress);
        NewPhone = (EditText) findViewById(R.id.etPhone);

        btnCamera = (Button)findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File imageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String photoName = getPhotoName();
                File imageFile = new File(imageDir, photoName);
                Uri imageUri = Uri.fromFile(imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(cameraIntent,REQUEST_PHOTO);
            }
        });

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
   private String getPhotoName(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String date = sdf.format(new Date());
        return "ClientPhoto" + date + ".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Bitmap cameraImage = (Bitmap)data.getExtras().get("data");
        //image.setImageBitmap(cameraImage);
    }
}











