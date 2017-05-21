package giaodien.admin.android_basics;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer play;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int loi = intent.getExtras().getInt("loi");
        play = MediaPlayer.create(getApplicationContext(), loi);
        Toast.makeText(getApplicationContext(), "Đang nghe nhạc",Toast.LENGTH_LONG).show();
        play.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        play.release();
        Toast.makeText(getApplicationContext(),"Dừng nhạc",Toast.LENGTH_LONG).show();


    }
}
