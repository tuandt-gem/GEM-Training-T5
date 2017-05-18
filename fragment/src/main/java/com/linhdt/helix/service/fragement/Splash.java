package com.linhdt.helix.service.fragement;


import android.os.Handler;

import com.linhdt.helix.service.MainActivity;

/**
 * Created by DangThanhLinh on 17/05/2017.
 */
public class Splash extends BaseFragment {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isAdded()) {
                ((MainActivity) getActivity()).toMenu();
            }
        }
    };

    public Splash(int idLayout) {
        super(idLayout);
        new Handler().postDelayed(runnable, 5000);
    }
}
