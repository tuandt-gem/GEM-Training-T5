package activity.minhhoang.uet.listview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MINHHOANG-PC on 15/05/2017.
 */

public class FragmentA extends Fragment {
    TextView textContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        textContent = (TextView) view.findViewById(R.id.txtContent);

        return view;
    }
}
