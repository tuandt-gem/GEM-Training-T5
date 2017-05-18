package gem.vn.uitask.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gem.vn.uitask.R;
import gem.vn.uitask.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private static final String TAG = FirstFragment.class.toString();

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.bt_next_fragment)
    public void onClick() {
        ((MainActivity) getActivity()).changeFragment(new SecondFragment(), true);
    }

}
