package com.luongapp.vanluong.androidbasic.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.luongapp.vanluong.androidbasic.R;
import com.luongapp.vanluong.androidbasic.adapter.SliderViewPagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DemoActivity extends AppCompatActivity {

    private String data;
    private Button btn_startActivityForResult;
    private static final int requestCode = 1;
    private Button btn_show_progress;
    private ProgressBar progressBar;
    private ArrayList<String> linkDemo;
    private ViewPager viewPager;
    private  Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        btn_startActivityForResult = (Button) findViewById(R.id.btn_startActivityForResult);
        btn_show_progress= (Button) findViewById(R.id.btn_show_progress);
        progressBar= (ProgressBar) findViewById(R.id.progress_bar);
        viewPager= (ViewPager) findViewById(R.id.viewPager);


        progressBar.setVisibility(View.GONE);

        data = getIntent().getExtras().getString("data").toString();
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        setBtn_startActivityForResult();
        setBtn_show_progress();

        setupSlider();


    }

    private void setupSlider(){
        linkDemo = new ArrayList<>();
        linkDemo.add("http://toananhdep.com/wp-content/uploads/2015/12/nhung-hinh-anh-hot-girl-xinh-tuoi-va-quyen-ru-nhat-viet-nam-1.jpg");
        linkDemo.add("http://hinhnendepnhat.net/wp-content/uploads/2016/09/hinh-nen-girl-xinh-cho-may-tinh-full-hd.jpg");
        linkDemo.add("http://toananhdep.com/wp-content/uploads/2015/12/nhung-hinh-anh-hot-girl-xinh-tuoi-va-quyen-ru-nhat-viet-nam-1.jpg");
        linkDemo.add("http://toananhdep.com/wp-content/uploads/2015/12/nhung-hinh-anh-hot-girl-xinh-tuoi-va-quyen-ru-nhat-viet-nam-1.jpg");

        SliderViewPagerAdapter sliderViewPagerAdapter=new SliderViewPagerAdapter(this, linkDemo);

        viewPager.setAdapter(sliderViewPagerAdapter);

         timer=new Timer();
        timer.scheduleAtFixedRate(new SliderTimeTask(), 2000, 4000);

    }

    @Override
    protected void onStop() {
        super.onStop();

        timer.cancel();
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

    public class SliderTimeTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<linkDemo.size(); i++){

                        if (viewPager.getCurrentItem()==linkDemo.size()-1){
                            viewPager.setCurrentItem(0);
                            break;
                        }else if (viewPager.getCurrentItem()==i){
                            viewPager.setCurrentItem(i+1);
                            break;
                        }
                    }
                }
            });
        }
    }

}
