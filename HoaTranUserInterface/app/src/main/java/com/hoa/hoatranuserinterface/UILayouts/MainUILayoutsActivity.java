package com.hoa.hoatranuserinterface.UILayouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hoa.hoatranuserinterface.R;

import java.util.ArrayList;

public class MainUILayoutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_uilayouts);

        final ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Table Layout");
        arrayList.add("Frame Layout");
        arrayList.add("Absolute Layout");
        arrayList.add("GridView");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(listView.getItemAtPosition(position).equals("Table Layout"))
                    startActivity(new Intent(MainUILayoutsActivity.this, TableLayout.class));
                if (listView.getItemAtPosition(position).equals("Frame Layout"))
                    startActivity(new Intent(MainUILayoutsActivity.this, FrameLayout.class));
                if (listView.getItemAtPosition(position).equals("Absolute Layout"))
                    startActivity(new Intent(MainUILayoutsActivity.this, AbsoluteLayout.class));
                if (listView.getItemAtPosition(position).equals("GridView"))
                    startActivity(new Intent(MainUILayoutsActivity.this, GridViewExample.class));
            }
        });

    }
}
