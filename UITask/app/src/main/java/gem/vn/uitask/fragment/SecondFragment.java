package gem.vn.uitask.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gem.vn.uitask.R;
import gem.vn.uitask.activities.MainActivity;
import gem.vn.uitask.adapters.FruitAdapter;
import gem.vn.uitask.models.Fruit;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    @BindView(R.id.lv_fruit)
    ListView lvFruit;

    private FruitAdapter fruitAdapter;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        fruitAdapter = new FruitAdapter(getContext(), R.layout.item_fruit, Arrays.asList(Fruit.FRUITS));
        lvFruit.setAdapter(fruitAdapter);
    }

    @OnClick(R.id.bt_next_fragment)
    public void onClick() {
        MainActivity activity = (MainActivity) getActivity();
        ThirdFragment fragment = new ThirdFragment();
        fragment.setOnItemAction(activity);
        activity.changeFragment(fragment, true);
    }

}
