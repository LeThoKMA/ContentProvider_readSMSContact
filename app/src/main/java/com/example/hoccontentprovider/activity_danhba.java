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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_danhba extends AppCompatActivity {
ListView lvDanhba;
ArrayList<DanhBa> danhBas;
ArrayAdapter<DanhBa> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhba);
        permissionContact();
        addControl();
        addEvent();
        showAllContactFromDevice();
    }

    private void permissionContact() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        1);
            }
        }
    }

    private void showAllContactFromDevice() {
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                Cursor cursor=getContentResolver().query(uri,null,null,null);
            danhBas.clear();
            while(cursor.moveToNext())
            {
                String nameCol=ContactsContract.Contacts.DISPLAY_NAME;
                String phoneCol=ContactsContract.CommonDataKinds.Phone.NUMBER;
                int colName=cursor.getColumnIndex(nameCol);
                int colPhone=cursor.getColumnIndex(phoneCol);
                String name=cursor.getString(colName);
                String phone=cursor.getString(colPhone);
                DanhBa db=new DanhBa(name,phone);
                danhBas.add(db);

            }
            cursor.close();
            adapter.notifyDataSetChanged();
            Toast.makeText(activity_danhba.this,"Run",Toast.LENGTH_LONG).show();
        }
    }

    private void addEvent() {
    }

    private void addControl() {
        lvDanhba=findViewById(R.id.lvDanhba);
        danhBas=new ArrayList<>();
        adapter=new ArrayAdapter<DanhBa>(activity_danhba.this, android.R.layout.simple_list_item_1,danhBas);
        lvDanhba.setAdapter(adapter);

    }
}