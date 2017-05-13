package com.luongapp.vanluong.androidbasic.view.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.luongapp.vanluong.androidbasic.R;
import com.luongapp.vanluong.androidbasic.service.PlayMusic;

/**
 * Created by vanluong on 12/05/2017.
 */

public class FragmentOne extends BaseFragment {

    private EditText edit;
    private Button btn_show_edit;
    private TextView txt_show_edit;
    private CheckBox check_android;
    private CheckBox check_ios;
    private Button btn_show_check;
    private ToggleButton btn_toggle;
    private RadioButton radio;
    private Button btn_show_radio;
    private Button btn_run_service;
    private RadioGroup radioGroup;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_one_layout, container, false);

        edit= (EditText) rootView.findViewById(R.id.edit);
        btn_show_edit= (Button) rootView.findViewById(R.id.btn_show_edit);
        txt_show_edit= (TextView) rootView.findViewById(R.id.txt_show_edit);
        check_android= (CheckBox) rootView.findViewById(R.id.check_android);
        check_ios= (CheckBox) rootView.findViewById(R.id.check_ios);
        btn_show_check= (Button) rootView.findViewById(R.id.btn_show_checkbox);
        btn_toggle= (ToggleButton) rootView.findViewById(R.id.btn_toggle);
        btn_show_radio= (Button) rootView.findViewById(R.id.btn_show_radio);
        btn_run_service= (Button) rootView.findViewById(R.id.btn_run_service);
        radioGroup= (RadioGroup) rootView.findViewById(R.id.radio_group);

        setBtn_show_edit();
        setBtn_run_rvice();
        setBtn_toggle();
        setBtn_sh_radio(rootView);
        setBtn_show_check();


        return rootView;
    }

    private void setBtn_show_edit(){

        btn_show_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_show_edit.setText(edit.getText().toString());
            }
        });

    }

    private void setBtn_show_check(){

        btn_show_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result="";
                if (check_android.isChecked()){
                    result=result+check_android.getText().toString()+" ";
                }


                if (check_ios.isChecked()){
                    result=result+check_ios.getText().toString();
                }

                Toast.makeText(getActivity(),"I LIKE "+ result, Toast.LENGTH_LONG).show();

            }
        });
    }

    private void setBtn_toggle(){
        btn_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_toggle.isChecked()){
                    Toast.makeText(getActivity(),"baatj", Toast.LENGTH_LONG).show();

                }else
                    Toast.makeText(getActivity(),"tat", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void setBtn_sh_radio(final View view){
        btn_show_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radio = (RadioButton) view.findViewById(selectedId);

                Toast.makeText(getActivity(),
                        radio.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setBtn_run_rvice(){
        btn_run_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getActivity(), PlayMusic.class));

            }
        });
    }
}
