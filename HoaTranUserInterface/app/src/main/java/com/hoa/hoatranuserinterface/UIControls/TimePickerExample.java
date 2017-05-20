package com.hoa.hoatranuserinterface.UIControls;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.hoa.hoatranuserinterface.R;

public class TimePickerExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_example);


        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        final TextView textViewTimePicker = (TextView) findViewById(R.id.textViewTimePicker);
        /*Calendar calendar;
        calendar.getInstance();*/

        Button buttonOkTimePicker = (Button) findViewById(R.id.buttonOkTimePicker);
        buttonOkTimePicker.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                String result =hour + " : " + minute;
                textViewTimePicker.setText(result);
            }
        });
    }
}
