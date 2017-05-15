package activity.minhhoang.uet.listview;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by MINHHOANG-PC on 15/05/2017.
 */

public class MyService extends Service {
MyBroadcast mbc;
    IntentFilter iten;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
         Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        registerReceiver(mbc,iten);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        iten = new IntentFilter();
        iten.addAction(Intent.ACTION_POWER_CONNECTED);
        iten.addAction(Intent.ACTION_POWER_DISCONNECTED);


        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
