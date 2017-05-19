package com.luongapp.vanluong.androidbasic.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.luongapp.vanluong.androidbasic.R;

public class DemoActivity extends AppCompatActivity {

    private String data;
    private Button btn_startActivityForResult;
    private static final int requestCode = 1;
    private Button btn_show_progress;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        btn_startActivityForResult = (Button) findViewById(R.id.btn_startActivityForResult);
        btn_show_progress= (Button) findViewById(R.id.btn_show_progress);
        progressBar= (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        data = getIntent().getExtras().getString("data").toString();
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        setBtn_startActivityForResult();
        setBtn_show_progress();


    }


    private void setBtn_show_progress(){
        btn_show_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

            }
        });
    }

    private void setBtn_startActivityForResult() {
        btn_startActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoActivity.this, SecondActivity.class);
                startActivityForResult(intent, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == SecondActivity.result_Ok) {
                Toast.makeText(this, data.getExtras().getString("result").toString(), Toast.LENGTH_SHORT).show();
            }

        }
    }

}
