package com.luongapp.vanluong.androidbasic.view.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.luongapp.vanluong.androidbasic.R;
import com.luongapp.vanluong.androidbasic.adapter.ViewPagerAdapter;
import com.luongapp.vanluong.androidbasic.view.ui.fragment.FragmentFour;
import com.luongapp.vanluong.androidbasic.view.ui.fragment.FragmentOne;
import com.luongapp.vanluong.androidbasic.view.ui.fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tabLayout= (TabLayout) findViewById(R.id.tabs);
        viewPager= (ViewPager) findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);

        setupViewPager();

        setupTab();

    }

    private void setupViewPager(){
         ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFrag(new FragmentOne(), "DEMO 1" );
        pagerAdapter.addFrag(new FragmentTwo(), "DEMO 2");
        pagerAdapter.addFrag(new FragmentFour(), "DEMO 3");

        viewPager.setAdapter(pagerAdapter);


    }

    private void setupTab(){
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor
                (ContextCompat.getColor(this, R.color.colorAccent));

    }
}
