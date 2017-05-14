package activity.minhhoang.uet.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{
    EditText txtA, txtB;

    Button btnTru;

    Button btnNhan, btnChia;

    Button btnAn;

    Button btnExit;

    View.OnClickListener suKienChiaSe = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvent();
    }

    private void addEvent() {
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyPhepTru();
            }
        });

        suKienChiaSe = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.btnNhan){
                    xuLyPhepNhan();
                }
                else if (view.getId()==R.id.btnChia){
                    xuLyPhepChia();
                }
            }
        };
        btnNhan.setOnClickListener(suKienChiaSe );
        btnChia.setOnClickListener(suKienChiaSe);
        btnAn.setOnLongClickListener(this);
        btnExit.setOnClickListener(new MyEvent());
    }

    private void xuLyPhepNhan() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int e = a*b;
        Toast.makeText(MainActivity.this,"Tích = "+e, Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepChia() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int f = a/b;
        Toast.makeText(MainActivity.this,"Thương = "+f, Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepTru() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int d = a-b;
        Toast.makeText(MainActivity.this,"Hiệu = "+d, Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnAn = (Button) findViewById(R.id.btnAn);
        btnExit = (Button) findViewById(R.id.btnExit);
    }

    public void xuLyPhepCong(View v){
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a+b;
        Toast.makeText(MainActivity.this,"Tổng = " + c,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId()==R.id.btnAn ){
            btnAn.setVisibility(view.INVISIBLE);
        }
        return false;
    }
    public class MyEvent implements View.OnClickListener, View.OnLongClickListener{

        @Override
        public void onClick(View view) {
            if (view.getId()==R.id.btnExit){
                finish();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}
