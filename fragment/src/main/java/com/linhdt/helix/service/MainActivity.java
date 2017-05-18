package com.linhdt.helix.service;

import android.os.Bundle;
import android.app.Activity;


import com.linhdt.helix.service.fragement.MenuFragment;
import com.linhdt.helix.service.fragement.PlayFragment;
import com.linhdt.helix.service.fragement.Splash;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private Splash splash = new Splash(R.layout.splash);
    private MenuFragment menuFargment = new MenuFragment(R.layout.menu);
    private PlayFragment playFragment = new PlayFragment(R.layout.play_game);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, splash).commit();
    }

    public void toMenu() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, menuFargment).commit();
    }

    public void toPlay() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, playFragment).commit();
    }
}

