package com.linhdt.helix.uicontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.linhdt.helix.uicontrols.autocomplete.AutoCompleteActivity;
import com.linhdt.helix.uicontrols.groupbutton.ButtonActivity;
import com.linhdt.helix.uicontrols.pick.PickActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn3, btn4;
    private ImageButton btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn_autocomplete);
        btn2 = (ImageButton) findViewById(R.id.btn_image);
        btn3 = (Button) findViewById(R.id.btn);
        btn4 = (Button) findViewById(R.id.btn_pick);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_autocomplete:
                intent = new Intent(this, AutoCompleteActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_image:
                Toast.makeText(this, "Click Image", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn:
                intent = new Intent(this, ButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_pick:
                intent = new Intent(this, PickActivity.class);
                startActivity(intent);
                break;

        }
    }
}
