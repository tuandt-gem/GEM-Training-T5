package giaodien.admin.bai11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnClick, btnLongClick, btnTouch;
    private EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        addControls();

        addLongClickEvents();
        addTouchEvents();
    }
    public void addControls() {
        // Cham vao r nha ra
        edtName = (EditText) findViewById(R.id.edtName);
        btnClick = (Button) findViewById(R.id.btnClick);
        btnLongClick = (Button) findViewById(R.id.btnLongClick);
        btnTouch = (Button) findViewById(R.id.btnTouch);
    }

    // Nhan du dieu ve tu man hinh 2
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 100) {
            Toast.makeText(this, data.getExtras().getString("BACK"), Toast.LENGTH_SHORT).show();
        }
    }

    private void addTouchEvents() {
        View.OnTouchListener touch = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MainActivity.this, "GEM", Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        btnTouch.setOnTouchListener(touch);
    }



    public void Clickbtn(View view) {
        // Khoi tao
        Intent intent = new Intent(this, ReceiveActivity.class);
        // Tao du lieu
        intent.putExtra("NAME", edtName.getText().toString());
        // gui de xem man hinh nao tra ve
        startActivityForResult(intent, 1);
    }


    public void addLongClickEvents() {
        View.OnLongClickListener longClick = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Long C", Toast.LENGTH_SHORT).show();

                return false;
            }
        };
        btnLongClick.setOnLongClickListener(longClick);
    }

    }











