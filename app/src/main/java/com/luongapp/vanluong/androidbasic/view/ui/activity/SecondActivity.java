package com.luongapp.vanluong.androidbasic.view.ui.activity;

import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.luongapp.vanluong.androidbasic.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public static final int result_Ok = 2;
    private Button btn_back;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_back = (Button) findViewById(R.id.btn_back);
        lv = (ListView) findViewById(R.id.lv_contacts);

        setBtn_back();
        showAllContacts();
    }



    private void setBtn_back() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "hello");
                setResult(result_Ok, returnIntent);
                finish();
            }
        });
    }



    public void showAllContacts() {
        Uri uri = Uri.parse("content://contacts/people");

        ArrayList<String> list = new ArrayList<String>();

        CursorLoader loader = new
                CursorLoader(this, uri, null, null, null, null);
        Cursor c1 = loader.loadInBackground();
        c1.moveToFirst();
        while (c1.isAfterLast() == false) {
            String s = "";
            String idColumnName = ContactsContract.Contacts._ID;

            int idIndex = c1.getColumnIndex(idColumnName);
            s = c1.getString(idIndex) + " - ";

            String nameColumnName = ContactsContract.Contacts.DISPLAY_NAME;

            int nameIndex = c1.getColumnIndex(nameColumnName);

            s += c1.getString(nameIndex);
            c1.moveToNext();
            list.add(s);
        }
        c1.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }
}
