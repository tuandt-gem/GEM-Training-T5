package giaodien.admin.bai11;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {
    private TextView txtName;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        txtName = (TextView) findViewById(R.id.txtName);
        btnBack = (Button) findViewById(R.id.btnBack);
        final Intent intent = getIntent();
        String name = intent.getExtras().getString("NAME");
        txtName.setText(name);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("BACK","Da chao roi");
                // 100 la ma de nhan biet ket qua tra ve
                setResult(100,intent);
                finish();
            }
        });
    }

}
