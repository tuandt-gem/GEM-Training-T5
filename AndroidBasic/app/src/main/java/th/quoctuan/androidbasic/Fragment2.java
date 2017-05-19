package th.quoctuan.androidbasic;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    List<People> model = new ArrayList<People>();
    static EditText copy;
    ListView list;
    MyAdapter myAdapter = null;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, container, false);
        copy = (EditText) v.findViewById(R.id.editText1);
        list = (ListView) v.findViewById(R.id.list);
        myAdapter = new MyAdapter();
        list.setAdapter(myAdapter);

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        People p = new People("A", "1234");
        People p1 = new People("B", "2345");
        People p2 = new People("C", "3456");
        People p3 = new People("D", "4567");
        People p4 = new People("E", "5678");
        People p5 = new People("F", "6789");
        myAdapter.addAll(p, p1, p2, p3, p4, p5);

        Uri uri = Uri.parse("content://com.tuandq.androidbasic/people");
        ContentValues ct = new ContentValues();
        ct.put("name", "Tuan2");
        ct.put("number", "123412345");
        getActivity().getApplicationContext().getContentResolver().insert(uri, ct);


        ContentValues ct1 = new ContentValues();
        ct1.put("name", "Tuan");
        ct1.put("number", "1234354");
        getActivity().getApplicationContext().getContentResolver().insert(uri, ct1);

        Cursor c = getActivity().getApplicationContext().getContentResolver().query(uri, null, null, null, null);

        c.moveToFirst();
        for (int i = 0; i < c.getCount(); i++) {
            myAdapter.add(new People(c.getString(1), c.getString(2)));
            if (i != c.getCount()) c.moveToNext();
        }


    }



    public static void set(String x) {
        copy.setText(x);
    }

    static class People {
        private String name;
        private String number;

        public People() {
        }

        public People(String Name, String Number) {
            this.name = Name;
            this.number = Number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }


    class MyAdapter extends ArrayAdapter<People> {

        public MyAdapter() {
            super(getActivity().getApplicationContext(), R.layout.row, model);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            v = getActivity().getLayoutInflater().inflate(R.layout.row, parent, false);
            PeopleHolder p = new PeopleHolder(v);
            p.setData(model.get(position));

            return v;
        }
    }

    static class PeopleHolder {
        private TextView name = null;
        private TextView number = null;

        PeopleHolder(View v) {
            name = (TextView) v.findViewById(R.id.textViewName);
            number = (TextView) v.findViewById(R.id.textViewNumber);
        }

        void setData(People p) {
            name.setText(p.getName().toString());
            number.setText(p.getNumber().toString());
        }
    }
}
