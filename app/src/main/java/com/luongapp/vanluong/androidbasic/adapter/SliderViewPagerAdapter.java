package com.luongapp.vanluong.androidbasic.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luongapp.vanluong.androidbasic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by vanluong on 21/05/2017.
 */

public class SliderViewPagerAdapter extends PagerAdapter{
    private Context context;
    private ArrayList<String> image;
    private LayoutInflater inflater;

    public SliderViewPagerAdapter(Context context, ArrayList<String> image){
        this.context=context;
        this.image=image;
    }
    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.image_layout, null);
        ImageView imageView= (ImageView) view.findViewById(R.id.imageSlider);

        Picasso.with(context)
                .load(image.get(position))
                .centerCrop()
                .resize(200, 200)
                .into(imageView);

        ViewPager vp= (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp= (ViewPager) container;
        View view= (View) object;
        vp.removeView(view);
    }
}
