package activity.minhhoang.uet.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static activity.minhhoang.uet.listview.R.id.btnAdd;
import static activity.minhhoang.uet.listview.R.id.btnUpdate;
import static activity.minhhoang.uet.listview.R.id.txtSub;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    EditText textSub;
    Button butAdd;
    Button butUpdate;
    ArrayList<String>arrayCourse;
    int viTri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        getEvent();
    }

    private void addControl() {
        lvMonHoc = (ListView) findViewById(R.id.lvSubject);
        textSub = (EditText) findViewById(R.id.txtSub);
        butAdd = (Button) findViewById(R.id.btnAdd);
        butUpdate = (Button) findViewById(R.id.btnUpdate);

    }
    private  void getEvent(){
        arrayCourse = new ArrayList<>();

        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("iOS");
        arrayCourse.add("Unity");
        arrayCourse.add(".Net");

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1, arrayCourse);

        lvMonHoc.setAdapter(adapter);
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+arrayCourse.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = textSub.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textSub.setText(arrayCourse.get(position));
                viTri = position;
            }
        });
        butUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(viTri,textSub.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayCourse.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
