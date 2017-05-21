package com.linhdt.helix.userinterface.lisview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.linhdt.helix.userinterface.R;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class ListViewActivity extends Activity {
    private FaceAdapter faceAdapter;
    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        lv = (ListView) findViewById(R.id.id_listview);
        faceAdapter = new FaceAdapter(this);
        lv.setAdapter(faceAdapter);

    }
}
