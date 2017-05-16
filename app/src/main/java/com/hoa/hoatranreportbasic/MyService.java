package com.hoa.hoatranreportbasic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        playMusic();
        Toast.makeText(this, "Service Create: phát nhạc mp3: Nơi này có anh", Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.

        playMusic();

        Toast.makeText(this, "Service Started: phát nhạc mp3: Nơi này có anh", Toast.LENGTH_LONG).show();

        return START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();

        player.stop();

    }

    public void playMusic(){
        player = MediaPlayer.create(this, R.raw.noinaycoanh);
        player.start();
    }
}
