package com.luongapp.vanluong.androidbasic.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * Created by vanluong on 12/05/2017.
 */

public class CheckConnectInternet extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (checkConnectInternet(context)) {
            Toast.makeText(context, "connect internet", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(context, "disconnect internet", Toast.LENGTH_LONG).show();


    }

    public boolean checkConnectInternet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
