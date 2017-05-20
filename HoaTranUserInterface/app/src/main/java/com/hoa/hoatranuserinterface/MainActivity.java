package com.hoa.hoatranuserinterface;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.hoa.hoatranuserinterface.UIControls.DatePickerExample;
import com.hoa.hoatranuserinterface.UIControls.TimePickerExample;
import com.hoa.hoatranuserinterface.UILayouts.MainUILayoutsActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<String> arrayList = new ArrayList<String>();
    TextView textView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList.add("Hà Nội");
        arrayList.add("Đà Nẵng");
        arrayList.add("TP.Hồ Chí Minh");
        arrayList.add("Nam Định");
        arrayList.add("Thái Bình");
        arrayList.add("Hải Dương");
        arrayList.add("Nghệ An");
        arrayList.add("Thanh Hóa");
        arrayList.add("Ninh Bình");

        //< TextView
        textView = (TextView) findViewById(R.id.textView);
        // TextView >

        //<ToggleButton
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ischeck = ((ToggleButton) view).isChecked();
                if (ischeck)
                    textView.setText("ToggleButton: ON");
                else
                    textView.setText("ToggleButton: OFF");
            }
        });
        // ToggleButton>

        //<CheckBox
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ischeck = ((CheckBox) view).isChecked();
                if (ischeck)
                    textView.setText("CheckBox : ON");
                else
                    textView.setText("CheckBox: OFF");
            }
        });
        // CheckBox>

        //<RadioGroup
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        Button buttonRadioGroup = (Button) findViewById(R.id.buttonRadioGroup);
        buttonRadioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                switch (selectedId) {
                    case R.id.radioButton1:
                        textView.setText("RadioGroup: radioButton1");
                        break;
                    case R.id.radioButton2:
                        textView.setText("RadioGroup: radioButton2");
                        break;
                }

            }
        });
        // RadioGroup>

        //<AutoCompleteTextView
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapterAutoCompleteTextView = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, arrayList);
        autoCompleteTextView.setThreshold(0);
        autoCompleteTextView.setAdapter(adapterAutoCompleteTextView);

        Button button = (Button) findViewById(R.id.buttonAutoCompleteTextView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultAutoCompleteTextView = (String) autoCompleteTextView.getText().toString(); // lấy nội dung của autoCompleteTextView hiện ra textView
                textView.setText("AutoCompleteTextView: " + resultAutoCompleteTextView);
            }
        });
        // AutoCompleteTextView>

        //<EditText
        final EditText editText = (EditText) findViewById(R.id.editText);

        Button button1 = (Button) findViewById(R.id.buttonEditText);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultEditText = (String) editText.getText().toString(); // lấy nội dung của EditText hiện ra textView
                textView.setText("EditText: " + resultEditText);
            }
        });
        //EditText>

        //<Spinner
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        spinner.setAdapter(adapterSpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setOnItemSelectedListener(this);
        //Spinner>

        //<ProgressBar
        Button buttonProgressDialog = (Button) findViewById(R.id.buttonProgressBar);
        buttonProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download();
            }
        });
        //ProgressBar>

        //<TimePicker
        Button buttonTimePicker = (Button) findViewById(R.id.buttonTimepicker1);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TimePickerExample.class));
            }
        });
        //TimePicker>

        //<DatePicker
        Button buttonDatePicker = (Button) findViewById(R.id.buttonDatePicker);
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DatePickerExample.class));
            }
        });
        // DatePicker>

        // < UI Layout
        Button buttonUILayout = (Button) findViewById(R.id.buttonUILayout);
        buttonUILayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainUILayoutsActivity.class));
            }
        });
        // UI Layout >

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String resultSpinner = adapterView.getItemAtPosition(position).toString();
        textView.setText("Spinner: " + resultSpinner);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    int jumpTime = 0;
    Handler progressHander = new Handler(); // use Handler of adroid.os
    Thread thread;
    ProgressDialog progress;
    public void download() {
        progress = new ProgressDialog(this);
        progress.setCancelable(true);
        progress.setMessage("Downloading Music");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setProgress(0);
        progress.setMax(100);
        progress.show();

        final int totalProgressTime = 100;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (jumpTime < 100) {
                    jumpTime += 5;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressHander.post(new Runnable() {
                        @Override
                        public void run() {
                            progress.setProgress(jumpTime);
                        }
                    });
                }

                if (jumpTime >= 100){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress.dismiss();
                }
            }
        });
        thread.start();


    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
