package th.quoctuan.androidbasic;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    BroadcastReceiver mPowerChargeReceiver;
    IntentFilter intentFilter;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction("com.tuandq.androidbasic");
        mPowerChargeReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                    Toast.makeText(getApplicationContext(), "Sạc pin được kết nối", Toast.LENGTH_SHORT).show();
                } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
                    Toast.makeText(getApplicationContext(), "Sạc pin đã được tháo bỏ", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Đã nhận broadcast được tạo", Toast.LENGTH_SHORT).show();

            }
        };
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        registerReceiver(mPowerChargeReceiver, intentFilter);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(mPowerChargeReceiver);
        super.onDestroy();

    }
}
