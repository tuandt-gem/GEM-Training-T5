package com.linhdt.helix.uicontrols.pick;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.linhdt.helix.uicontrols.R;

import java.util.Calendar;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class PickActivity extends Activity {
    private static final int DATE_DIALOG_ID = 999;
    private static final int TIME_DIALOG_ID = 888;
    private TimePicker timePicker1;
    private DatePicker dpResult;
    private Button btnPickDate, btnPicktime;
    private TextView dateView, timeView;
    private Calendar calendar;
    private int hour, minute, year, month, day;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_pick);
        initView();
    }

    private void initView() {

        dpResult = (DatePicker) findViewById(R.id.dpResult);
        timeView = (TextView) findViewById(R.id.tv_time);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        btnPicktime = (Button) findViewById(R.id.btn_picktime);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        btnPickDate = (Button) findViewById(R.id.btn_pickdate);
        dateView = (TextView) findViewById(R.id.tv_date);

        timePicker1.setCurrentHour(hour);
        timePicker1.setCurrentMinute(minute);

        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month + 1).append("/").append(year));
        timeView.setText(new StringBuilder().append(pad(hour))
                .append(":").append(pad(minute)));
        btnPicktime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
        btnPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }


    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month, day);
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        timePickerListener, hour, minute, false);

        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int selectedHour,
                                      int selectedMinute) {
                    hour = selectedHour;
                    minute = selectedMinute;
                    timePicker1.setCurrentHour(hour);
                    timePicker1.setCurrentMinute(minute);

                    // set current time into textview
                    timeView.setText(new StringBuilder().append(pad(hour))
                            .append(":").append(pad(minute)));
                }
            };
    private DatePickerDialog.OnDateSetListener datePickerListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    showDate(arg1, arg2 + 1, arg3);
                    dpResult.init(arg1, arg2, arg3, null);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


}
