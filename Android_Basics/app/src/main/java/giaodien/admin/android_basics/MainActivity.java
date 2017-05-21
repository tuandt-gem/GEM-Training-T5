package giaodien.admin.android_basics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNgheNhac(View view){
        Intent intent = new Intent(MainActivity.this, ListSongsActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void onClickXemThoiTiet(View view){
        Toast.makeText(this, "Chưa xử lý", Toast.LENGTH_SHORT).show();
    }
}
