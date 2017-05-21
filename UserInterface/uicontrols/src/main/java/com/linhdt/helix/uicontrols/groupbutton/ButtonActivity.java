package com.linhdt.helix.uicontrols.groupbutton;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.linhdt.helix.uicontrols.MainActivity;
import com.linhdt.helix.uicontrols.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class ButtonActivity extends Activity {
    public CheckBox cb1, cb2;
    public ImageButton imageButton;
    public ToggleButton toggleButton;

    public RadioGroup rgSex, rgDifficulty;
    public RadioButton rbMale, rbFemale;

    public ProgressBar progressBar;
    public Button show;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_button);

        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        toggleButton = (ToggleButton) findViewById(R.id.toggle);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        progressBar = (ProgressBar) findViewById(R.id.progess);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Thanks : ").append(cb1.isChecked());
                result.append("\nThanks: ").append(cb2.isChecked());
                result.append("\ntoggleButton : ").append(toggleButton.getText());
                Toast.makeText(ButtonActivity.this, result.toString(), Toast.LENGTH_LONG).show();

            }
        });
        rgSex = (RadioGroup) findViewById(R.id.rg_sex);
        rgDifficulty = (RadioGroup) findViewById(R.id.rg_difficulty);
        rbMale = (RadioButton) findViewById(R.id.rb_male);
        rbFemale = (RadioButton) findViewById(R.id.rb_female);
        show = (Button) findViewById(R.id.btn_show);

        rbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changSex(buttonView, isChecked);
            }
        });
        rbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changSex(buttonView, isChecked);
            }
        });

        rgDifficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                changDifficulty(group, checkedId);
                int checkedRadioId = group.getCheckedRadioButtonId();
                if (checkedRadioId == R.id.rb_easy) {
                    Toast.makeText(ButtonActivity.this, "You choose the level of difficulty: Easy", Toast.LENGTH_SHORT).show();
                } else if (checkedRadioId == R.id.rb_normal) {
                    Toast.makeText(ButtonActivity.this, "You choose the level of difficulty: Normal", Toast.LENGTH_SHORT).show();
                } else if (checkedRadioId == R.id.rb_hard) {
                    Toast.makeText(ButtonActivity.this, "You choose the level of difficulty: Hard", Toast.LENGTH_SHORT).show();
                }
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int difficultyLevel = rgDifficulty.getCheckedRadioButtonId();
                int gameCharacter = rgSex.getCheckedRadioButtonId();
                RadioButton diff = (RadioButton) findViewById(difficultyLevel);
                RadioButton sex = (RadioButton) findViewById(gameCharacter);
                String message = "Difficulty Level: " + diff.getText()
                        + ", Game Character: " + sex.getText();
                Toast.makeText(ButtonActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changSex(CompoundButton buttonView, boolean isChecked) {
        RadioButton radio = (RadioButton) buttonView;

        Log.i("LOGTAG", "RadioButton " + radio.getText() + " : " + isChecked);
    }


    private void changDifficulty(RadioGroup group, int checkedId) {

    }


}
