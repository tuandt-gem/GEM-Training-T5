package com.luongapp.vanluong.mycaculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.luongapp.vanluong.mycaculator.R.id.decimal;

public class MainActivity extends AppCompatActivity {

    private TextView txt_display;
    private Button btn_decimal;
    private String firtNumberString = "";
    private String secondNumberString = "";
    private String operation = "";
    private boolean check_firtNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_display = (TextView) findViewById(R.id.display);
        btn_decimal = (Button) findViewById(decimal);
    }

    public void numberButton(View v) {
        Button button = (Button) v;

        if (check_firtNumber) {
            firtNumberString = firtNumberString + button.getText().toString();
            txt_display.setText(firtNumberString);
        } else {
            secondNumberString = secondNumberString + button.getText().toString();
            txt_display.setText(secondNumberString);
        }


    }

    public void operationButton(View v) {
        Button button = (Button) v;

        check_firtNumber = false;
        operation = button.getText().toString();
        txt_display.setText(operation);
    }

    public void equalButton(View v) {

        try {

            double firtNumber, secondNumber, result = 0;

            firtNumber = Double.parseDouble(firtNumberString);
            secondNumber = Double.parseDouble(secondNumberString);

            check_firtNumber = true;

            switch (operation) {
                case "÷":
                    result = firtNumber / secondNumber;
                    break;
                case "×":
                    result = firtNumber * secondNumber;
                    break;
                case "-":
                    result = firtNumber - secondNumber;
                    break;
                case "+":
                    result = firtNumber + secondNumber;

            }

            firtNumberString = "";
            secondNumberString = "";
            operation = "";

            txt_display.setText(result + "");
        }catch (Exception e){
            Toast.makeText(this, "Bạn nhập sai cú pháp mời nhập lại", Toast.LENGTH_SHORT).show();
        }

    }


}
