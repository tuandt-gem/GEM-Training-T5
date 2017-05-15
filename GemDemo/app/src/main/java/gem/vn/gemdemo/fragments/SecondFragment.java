package gem.vn.gemdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.activities.MainActivity;
import gem.vn.gemdemo.events.OpenFragmentEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private static final String[] FRUITS = {"Kiwi", "Apple", "Orange"};

    @BindView(R.id.bt_UI)
    Button btUI;

    @BindView(R.id.ib_UI)
    ImageButton ibUI;

    @BindView(R.id.sp_UI)
    Spinner spUI;

    @BindView(R.id.bt_next_fragment)
    Button btNextFragment;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        ButterKnife.bind(this, view);
        setupSpinner();
        addListeners();

        return view;
    }

    private void setupSpinner() {
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, FRUITS);
        spUI.setAdapter(mAdapter);
    }

    private void addListeners() {
        btUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Button on click", Toast.LENGTH_SHORT).show();
            }
        });

        btUI.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(), "Button on long click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        ibUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Image button on click", Toast.LENGTH_SHORT).show();
            }
        });

        ibUI.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(), "Image button on long click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();

                ThirdFragment fragment = new ThirdFragment();
                fragment.setOnItemAction(activity);

                activity.changeFragment(fragment, true);
            }
        });
    }

}
