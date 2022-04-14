package com.example.hoccontentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_tinnhan extends AppCompatActivity {
ListView lvMes;
ArrayList<String> listMes;
ArrayAdapter<String> adapterTinnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tinnhan);
permissionRead();
      addControl();
        docTinNhan();
    }

    private void permissionRead() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_SMS},
                        1);
            }
        }
    }

    private void addControl() {
        lvMes=findViewById(R.id.lvMes);
        listMes=new ArrayList<>();
        adapterTinnhan=new ArrayAdapter<String>(MainActivity_tinnhan.this, android.R.layout.simple_list_item_1,listMes);
        lvMes.setAdapter(adapterTinnhan);
    }

    private void docTinNhan() {
        Uri uri= Telephony.Sms.CONTENT_URI;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           Cursor cursor = getContentResolver().query(uri, null, null, null,null);

            listMes.clear();
           // if(cursor.moveToFirst()){
            while(cursor.moveToNext()){

                int indexPhoneNum = cursor.getColumnIndex("address");
                int indexTimeStamp = cursor.getColumnIndex("date");
                int indexBody = cursor.getColumnIndex("body");

                String phoneNumber = cursor.getString(indexPhoneNum);
                String time = cursor.getString(indexTimeStamp);
                String body = cursor.getString(indexBody);
              listMes.add(phoneNumber + "\n" + time + "\n" + body);

            }

            cursor.close();
            adapterTinnhan.notifyDataSetChanged();

        }


    }
}