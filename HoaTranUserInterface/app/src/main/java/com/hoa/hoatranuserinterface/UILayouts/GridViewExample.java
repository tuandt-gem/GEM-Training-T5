package com.hoa.hoatranuserinterface.UILayouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.hoa.hoatranuserinterface.R;

import java.util.ArrayList;

public class GridViewExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_example);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("view1");
        arrayList.add("view2");
        arrayList.add("view3");
        arrayList.add("view4");
        arrayList.add("view5");
        arrayList.add("view6");
        arrayList.add("view7");
        arrayList.add("view8");
        arrayList.add("view9");
        arrayList.add("view10");
        arrayList.add("view11");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, arrayList);
        gridView.setAdapter(adapter);
    }
}
