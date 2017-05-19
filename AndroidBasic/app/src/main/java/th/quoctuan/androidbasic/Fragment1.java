package th.quoctuan.androidbasic;


import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment1 extends Fragment {
    EditText tdd;
    Fragment2 fg2;
    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment1, container, false);

        EditText text = (EditText) v.findViewById(R.id.textView);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Fragment2.set(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>3){
                    String t=s.toString().substring(s.toString().length()-4);
                    if(t.equals("stop")) {
                        getActivity().stopService(new Intent(getActivity().getApplicationContext(), MyService.class));
                        Toast.makeText(getActivity().getApplicationContext(),"Service stopped", Toast.LENGTH_SHORT).show();
                    }
                    if(t.equals("mnew")){
                        getActivity().startService(new Intent(getActivity().getApplicationContext(), MyService.class));
                        Toast.makeText(getActivity().getApplicationContext(),"Service started", Toast.LENGTH_SHORT).show();
                    }
                    if(t.equals("send")){
                        Intent intent = new Intent();
                        intent.setAction("com.tuandq.androidbasic");
                        getActivity().sendBroadcast(intent);

                    }

                }
            }
        });
        return v;
    }

}
