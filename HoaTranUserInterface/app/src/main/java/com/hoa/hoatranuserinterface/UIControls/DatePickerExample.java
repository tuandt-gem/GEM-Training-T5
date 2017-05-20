package com.hoa.hoatranuserinterface.UIControls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.hoa.hoatranuserinterface.R;

public class DatePickerExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_example);

        Button buttonDatePicker = (Button) findViewById(R.id.buttonDatePicker);
        final TextView textViewDatePicker = (TextView) findViewById(R.id.textViewDatePicker);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int date = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                String time = date + "/" + month + "/" + year;
                textViewDatePicker.setText(time);
            }
        });

    }
}
