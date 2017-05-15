package activity.minhhoang.uet.listview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * Created by MINHHOANG-PC on 15/05/2017.
 */

public class MyBroadcast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context,"Power Connected", Toast.LENGTH_SHORT).show();
        }else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context, "Power Disconnect", Toast.LENGTH_SHORT).show();
        }
    }
}
