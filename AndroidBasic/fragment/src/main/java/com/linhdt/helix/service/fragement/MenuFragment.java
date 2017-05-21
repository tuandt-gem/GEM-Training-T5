package com.linhdt.helix.service.fragement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.linhdt.helix.service.MainActivity;
import com.linhdt.helix.service.R;

/**
 * Created by DangThanhLinh on 17/05/2017.
 */

public class MenuFragment extends BaseFragment implements View.OnClickListener {

    private Button btnPlay, btnOption, btnExit;

    public MenuFragment(int idLayout) {
        super(idLayout);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        init();
        return view;
    }

    private void init() {
        btnPlay = (Button) rootView.findViewById(R.id.btn_play);
        btnOption = (Button) rootView.findViewById(R.id.btn_option);
        btnExit = (Button) rootView.findViewById(R.id.btn_exit);

        btnPlay.setOnClickListener(this);
        btnOption.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                Toast.makeText(getActivity(), "play game", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).toPlay();
                break;
            case R.id.btn_option:
                Toast.makeText(getActivity(), "Click Option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_exit:
                Toast.makeText(getActivity(), "Click Exit", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
