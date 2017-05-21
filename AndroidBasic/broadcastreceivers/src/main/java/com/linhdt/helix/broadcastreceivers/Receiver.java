package com.linhdt.helix.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by DangThanhLinh on 17/05/2017.
 */

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                int status = Settings.Global.getInt(context.getContentResolver(),
                        Settings.Global.AIRPLANE_MODE_ON, 0);
                if (status == 0) {
                    Toast.makeText(context, "Air plane mode off reciver",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Air plane mode on reciver",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case Intent.ACTION_NEW_OUTGOING_CALL:
                Toast.makeText(context, "You arre calling out......", Toast.LENGTH_SHORT).show();

            default:
                break;
        }
    }
}
