package com.hoa.hoatranreportbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by khách on 15/05/2017.
 */

public class Fragment1 extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_1, container, false);

            final Button startService = (Button) view.findViewById(R.id.buttonStartService);
            startService.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().startService(new Intent(getActivity().getBaseContext(), MyService.class));
                }
            });

            Button stopService = (Button) view.findViewById(R.id.buttonStopService);
            stopService.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
                }
            });

            return view;
        }

}
