package com.linhdt.helix.userinterface.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;

import com.linhdt.helix.userinterface.R;
import com.linhdt.helix.userinterface.lisview.FaceAdapter;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class GridviewActivity extends Activity {
    private FaceAdapter faceAdapter;
    private GridView gv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        gv = (GridView) findViewById(R.id.id_gridview);
        faceAdapter = new FaceAdapter(this);
        gv.setAdapter(faceAdapter);


    }
}
