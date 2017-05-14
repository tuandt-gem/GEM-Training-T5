package gem.vn.gemdemo.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.events.BroadcastEvent;
import gem.vn.gemdemo.events.OpenFragmentEvent;
import gem.vn.gemdemo.services.MyService;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    @BindView(R.id.bt_start_service)
    Button btStartService;

    @BindView(R.id.bt_stop_service)
    Button btStopService;

    @BindView(R.id.bt_broadcast)
    Button btBroadcast;

    @BindView(R.id.bt_next_fragment)
    Button btNextFragment;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        initInstances(view);
        addListeners();

        return view;
    }

    private void initInstances(View v) {
        ButterKnife.bind(this, v);
    }

    private void addListeners() {
        btStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getActivity(), MyService.class));
            }
        });

        btStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(new Intent(getActivity(), MyService.class));
            }
        });

        btBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new BroadcastEvent());
            }
        });

        btNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new OpenFragmentEvent(new SecondFragment(), true));
            }
        });
    }

}
