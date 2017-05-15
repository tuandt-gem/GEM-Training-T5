package activity.minhhoang.uet.listview;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import static activity.minhhoang.uet.listview.R.id.btnAddFragment;
import static activity.minhhoang.uet.listview.R.id.btnUpdate;
import static activity.minhhoang.uet.listview.R.id.txtSub;

public class MainActivity extends AppCompatActivity {
    String msg = "Android";
    ListView lvMonHoc;
    EditText textSub;
    Button butAdd;
    Button butUpdate;
    Button butStart;
    Button butStop;
    Button butAddFragment;
    ArrayList<String>arrayCourse;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test", "onCreate Start");
        Log.d(msg,"The onCreate()event");
        addControl();
        getEvent();
    }

    private void addControl() {
        lvMonHoc = (ListView) findViewById(R.id.lvSubject);
        textSub = (EditText) findViewById(R.id.txtSub);
        butAdd = (Button) findViewById(R.id.btnAdd);
        butUpdate = (Button) findViewById(R.id.btnUpdate);
        butStart = (Button) findViewById(R.id.btnStart);
        butStop = (Button) findViewById(R.id.btnStop);
        butAddFragment = (Button) findViewById(R.id.btnAddFragment);

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
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(MainActivity.this, ""+arrayCourse.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        android.app.FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        butAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragmentA =new FragmentA();
                fragmentTransaction.add(R.id.Constrainlayout,fragmentA);
                fragmentTransaction.commit();
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
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                textSub.setText(arrayCourse.get(i));
                position = i;
            }
        });
        butUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(position,textSub.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    public void startService(View view){
        startService(new Intent(getBaseContext(),MyService.class));
    }
    public void stopService(View view){
        stopService(new Intent(getBaseContext(),MyService.class));
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test", "onCreate Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test", "onResume Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test", "onPause Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test", "onStop Start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test", "onDestroy Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test", "onRestart Start");
    }
}
