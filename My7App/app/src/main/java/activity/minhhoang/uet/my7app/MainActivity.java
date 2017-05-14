package activity.minhhoang.uet.my7app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkFootball, chkBadminton, chkDance;
    Button btnChon;
    TextView txtSoThich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        getEvent();
    }

    private void addControl() {
        chkFootball = (CheckBox) findViewById(R.id.chkFootball);
        chkBadminton = (CheckBox) findViewById(R.id.chkBadminton);
        chkDance = (CheckBox) findViewById(R.id.chkDance);
        btnChon = (Button) findViewById(R.id.btnChon);
        txtSoThich = (TextView) findViewById(R.id.txtSoThich);
    }

    private void getEvent() {
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChonSoThich();
            }
        });
    }

    private void xuLyChonSoThich() {
        String s="";
        if(chkFootball.isChecked()){
            s+=chkFootball.getText().toString()+"\n";
        }
        if (chkDance.isChecked()){
            s+=chkDance.getText().toString()+"\n";
        }
        if (chkBadminton.isChecked()){
            s+=chkBadminton.getText().toString();
        }
        txtSoThich.setText(s);
    }

}
