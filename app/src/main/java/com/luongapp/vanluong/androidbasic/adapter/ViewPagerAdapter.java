package com.luongapp.vanluong.androidbasic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanluong on 06/03/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList=new ArrayList<>();
    private List<String> mFragmentTitleList=new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }



    public void addFrag(Fragment fragment, String title){


        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);

    }

    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return ViewPagerAdapter.POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }


}
