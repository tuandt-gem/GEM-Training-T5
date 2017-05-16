package com.hoa.hoatranreportbasic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by khách on 14/05/2017.
 */

public class NetworkChangeReceiverUseManifest extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) { //phương thức nhận kết quả lắng nghe
        Toast.makeText(context, "Network is turned ON/OF", Toast.LENGTH_SHORT).show();
    }
}
