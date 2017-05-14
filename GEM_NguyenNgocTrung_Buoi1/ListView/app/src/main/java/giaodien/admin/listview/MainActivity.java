package giaodien.admin.listview;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity{
    EditText edtTen,edtId;
    TextView txtvShow;
    Button btnAdd;
    RadioGroup rdgrGen;
    ListView listPokemon;
    ArrayList<Pokemon> arrayPokemon=new ArrayList<Pokemon>();
    CustomAdapter customAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        addControls();
        setListView();
        addEvent();
    }

    public void addControls() {
        edtTen = (EditText) findViewById(R.id.edtTen);
        edtId = (EditText) findViewById(R.id.edtId);
        txtvShow = (TextView) findViewById(R.id.txtvShow);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        rdgrGen =(RadioGroup) findViewById(R.id.rdgrGen);
        listPokemon = (ListView) findViewById(R.id.lstResult);
    }

    public void setListView() {
        customAdapter = new CustomAdapter(this,R.layout.my_item_layout,arrayPokemon);
        listPokemon.setAdapter(customAdapter);
    }

    public void onClickAdd(View v) {
        String id=edtId.getText().toString();
        if(id.isEmpty()) {
            Toast.makeText(this, "Ban phai nhap Id", Toast.LENGTH_SHORT).show();
            edtId.selectAll();
            return;
        }
        String ten=edtTen.getText().toString();
        if(ten.isEmpty()) {
            Toast.makeText(this, "Ban phai nhap Ten", Toast.LENGTH_SHORT).show();
            edtId.selectAll();
            return;
        }
        int selected=rdgrGen.getCheckedRadioButtonId();
        RadioButton r = (RadioButton) findViewById(selected);
        String gen = r.getText().toString();
        if(gen.isEmpty()) {
            Toast.makeText(this, "Ban phai chon Gen", Toast.LENGTH_SHORT).show();
            edtId.selectAll();
            return;
        }


        Pokemon pkm =new Pokemon();
        pkm.setId(id);
        pkm.setName(ten);
        pkm.setGen(gen);

        arrayPokemon.add(pkm);
        customAdapter.notifyDataSetChanged();
        edtTen.setText("");
        edtId.requestFocus();
        edtId.setText("");
    }

    public void addEvent() {

        listPokemon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pokemon pkm=arrayPokemon.get(i);
                arrayPokemon.remove(pkm);
                customAdapter.notifyDataSetChanged();
                return false;
            }
        });

         listPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 txtvShow.setText(arrayPokemon.get(i).getGen());
             }
         });

    }
}
