package gem.vn.uitask.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.uitask.R;
import gem.vn.uitask.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourthFragment extends Fragment {

    private static final String[] SPINNER_FRUITS = new String[] {
            "Blue", "Green", "Red", "Violet", "Brown", "White"
    };

    private static final String[] HINTS = new String[] {
            "Hi there!", "Hint was shown", "Hit", "High five"
    };

    @BindView(R.id.actv_UI)
    AutoCompleteTextView actvUI;

    @BindView(R.id.ib_UI)
    ImageButton ibUI;

    @BindView(R.id.tb_UI)
    ToggleButton tbUI;

    @BindView(R.id.sp_UI)
    Spinner spUI;

    @BindView(R.id.rb_male)
    RadioButton rbMale;

    @BindView(R.id.rb_female)
    RadioButton rbFemale;

    @BindView(R.id.rb_other)
    RadioButton rbOther;

    @BindView(R.id.bt_next_fragment)
    Button btNextFragment;

    public FourthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        addListeners();
        return view;
    }

    private void setupUI() {
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                SPINNER_FRUITS);
        spUI.setAdapter(mAdapter);

        actvUI.setAdapter(new ArrayAdapter<String>(
                getActivity(), android.R.layout.select_dialog_item, HINTS
        ));
    }

    private void addListeners() {


        ibUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "The image button was clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ibUI.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(), "The image button was long clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        tbUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isOn = tbUI.isChecked();
                String msg;
                if (isOn) {
                    msg = "on";
                } else {
                    msg = "off";
                }
                Toast.makeText(getActivity(), "The toggle button was clicked, it's now " + msg, Toast.LENGTH_SHORT).show();
            }
        });

        spUI.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), SPINNER_FRUITS[position] + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rbMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You're a " + rbMale.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        rbFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You're a " + rbFemale.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        rbOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Your sex is unidentified", Toast.LENGTH_SHORT).show();
            }
        });

        btNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).changeFragment(new FifthFragment(), true);
            }
        });
    }

}
