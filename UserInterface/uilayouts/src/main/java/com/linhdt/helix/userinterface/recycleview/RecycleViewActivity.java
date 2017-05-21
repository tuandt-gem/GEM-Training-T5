package com.linhdt.helix.userinterface.recycleview;

import android.app.Activity;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.linhdt.helix.userinterface.R;
import com.linhdt.helix.userinterface.lisview.FaceItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class RecycleViewActivity extends AppCompatActivity {
    private List<FaceItem> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterRecycle mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        mAdapter = new AdapterRecycle(this, list);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        list.add(new FaceItem(R.drawable.ic_oh, "Oh"));
        list.add(new FaceItem(R.drawable.ic_matrix, "Matrix"));
        list.add(new FaceItem(R.drawable.ic_sweet_kiss, "Sweet kiss"));
        list.add(new FaceItem(R.drawable.ic_oh, "Oh"));
        list.add(new FaceItem(R.drawable.ic_matrix, "Matrix"));
        list.add(new FaceItem(R.drawable.ic_oh, "Oh"));
        list.add(new FaceItem(R.drawable.ic_matrix, "Matrix"));
        list.add(new FaceItem(R.drawable.ic_sweet_kiss, "Sweet kiss"));
        list.add(new FaceItem(R.drawable.ic_oh, "Oh"));
        list.add(new FaceItem(R.drawable.ic_matrix, "Matrix"));
        list.add(new FaceItem(R.drawable.ic_sweet_kiss, "Sweet kiss"));

    }
}
