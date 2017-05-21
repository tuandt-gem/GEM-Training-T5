package com.linhdt.helix.userinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.linhdt.helix.userinterface.gridview.GridviewActivity;
import com.linhdt.helix.userinterface.layout.LayoutActivity;
import com.linhdt.helix.userinterface.lisview.ListViewActivity;
import com.linhdt.helix.userinterface.recycleview.RecycleViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn_layout);
        btn2 = (Button) findViewById(R.id.btn_Listview);
        btn3 = (Button) findViewById(R.id.btn_gridview);
        btn4 = (Button) findViewById(R.id.btn_recycleview);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_layout:
                intent = new Intent(this, LayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Listview:
                intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_gridview:
                intent = new Intent(this, GridviewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_recycleview:
                intent = new Intent(this, RecycleViewActivity.class);
                startActivity(intent);
                break;

        }
    }
}
