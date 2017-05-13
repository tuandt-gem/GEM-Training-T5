package com.luongapp.vanluong.androidbasic.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.luongapp.vanluong.androidbasic.R;

/**
 * Created by vanluong on 12/05/2017.
 */

public class FragmentTwo extends BaseFragment{
    private TimePicker timePicker;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_two_layout, container, false);
        timePicker= (TimePicker) rootView.findViewById(R.id.time_picker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getActivity(), hourOfDay+":"+minute, Toast.LENGTH_LONG).show();
            }
        });


        return rootView;
    }
}
