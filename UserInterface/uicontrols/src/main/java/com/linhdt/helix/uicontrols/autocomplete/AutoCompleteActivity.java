package com.linhdt.helix.uicontrols.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.linhdt.helix.uicontrols.R;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class AutoCompleteActivity extends Activity {
    private TextView tv;
    private AutoCompleteTextView completeTextView;


    String[] arr = {"Paries,France", "PA,United States", "Parana,Brazil", "Padua,Italy", "Pasadena,CA,United States"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete);

        tv = (TextView) findViewById(R.id.textView2);
        completeTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> arrs = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, arr);
        completeTextView.setThreshold(2);
        completeTextView.setAdapter(arrs);

    }
}
