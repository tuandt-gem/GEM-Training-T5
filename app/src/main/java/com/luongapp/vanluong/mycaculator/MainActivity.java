package com.luongapp.vanluong.mycaculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txt_display;
    private TextView txt_displayOperation;


    private String firtNumberString = "";
    private String secondNumberString = "";
    private String operation = "";
    private boolean check_firtNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_display = (TextView) findViewById(R.id.display_result);
        txt_displayOperation= (TextView) findViewById(R.id.display);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.item_delete:

                check_firtNumber = true;
                firtNumberString = "";
                secondNumberString = "";
                operation = "";
                
                txt_display.setText("");
                txt_displayOperation.setText("");

                break;

        }


        return true;
    }

    public void numberButton(View v) {
        Button button = (Button) v;
        txt_displayOperation.append(button.getText().toString());

        if (check_firtNumber) {
            firtNumberString = firtNumberString + button.getText().toString();
        } else {
            secondNumberString = secondNumberString + button.getText().toString();
        }


    }

    public void operationButton(View v) {
        Button button = (Button) v;

        check_firtNumber = false;
        operation = button.getText().toString();
        txt_displayOperation.append(button.getText().toString());

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
            txt_displayOperation.setText("");
        } catch (Exception e) {
            Toast.makeText(this, "Bạn nhập sai cú pháp mời nhập lại", Toast.LENGTH_SHORT).show();
        }

    }


}
