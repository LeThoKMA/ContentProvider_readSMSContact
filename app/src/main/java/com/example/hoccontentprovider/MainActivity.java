package com.example.hoccontentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void xuLiDocDanhBa(View view) {
        Intent intent=new Intent(MainActivity.this,activity_danhba.class);
        startActivity(intent);
    }

    public void xulidoctinnhan(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity_tinnhan.class);
        startActivity(intent);
    }
}