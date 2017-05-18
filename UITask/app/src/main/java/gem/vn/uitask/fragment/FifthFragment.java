package gem.vn.uitask.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.uitask.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FifthFragment extends Fragment {

    private static final String TAG = FifthFragment.class.toString();

    @BindView(R.id.timePicker)
    TimePicker timePicker;

    @BindView(R.id.datePicker)
    DatePicker datePicker;

    @BindView(R.id.bt_get_time)
    Button btGetTime;

    public FifthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fifth, container, false);
        ButterKnife.bind(this, view);
        addListeners();
        return view;
    }

    private void addListeners() {
        btGetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = String.valueOf(timePicker.getCurrentHour()) + ":" + String.valueOf(timePicker.getCurrentMinute());
                String date = String.valueOf(datePicker.getDayOfMonth()) + "/" + String.valueOf(datePicker.getMonth() + 1)
                        + "/" + String.valueOf(datePicker.getYear());
                Toast.makeText(getActivity(), "Time and date picked: " + time + " - " + date, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
