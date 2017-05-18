package com.linhdt.helix.service.fragement;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DangThanhLinh on 17/05/2017.
 */

public class BaseFragment extends Fragment {
    private int idLayout;
    protected View rootView;

    public BaseFragment(int idLayout) {
        this.idLayout = idLayout;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(idLayout, container, false);
        return rootView;
    }
}
