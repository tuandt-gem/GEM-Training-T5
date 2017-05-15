package com.luongapp.vanluong.androidbasic.view.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.luongapp.vanluong.androidbasic.R;
import com.luongapp.vanluong.androidbasic.view.ui.activity.DemoActivity;

/**
 * Created by vanluong on 12/05/2017.
 */

public class FragmentTwo extends BaseFragment{

    private TimePicker timePicker;
    private Button btn_startActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_two_layout, container, false);

        timePicker= (TimePicker) rootView.findViewById(R.id.time_picker);
        btn_startActivity= (Button) rootView.findViewById(R.id.btn_startActivity);


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getActivity(), hourOfDay+":"+minute, Toast.LENGTH_LONG).show();
            }
        });

        setBtn_startActivity();


        return rootView;
    }

    private void setBtn_startActivity(){
        btn_startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), DemoActivity.class);
                intent.putExtra("data", "hello");

                startActivity(intent);
            }
        });
    }


}
