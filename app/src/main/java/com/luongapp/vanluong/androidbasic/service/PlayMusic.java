package com.luongapp.vanluong.androidbasic.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.luongapp.vanluong.androidbasic.R;

/**
 * Created by vanluong on 12/05/2017.
 */

public class PlayMusic extends Service {

    private  MediaPlayer mPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       mPlayer = MediaPlayer.create(this, R.raw.wakeupalone);
        mPlayer.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();

    }
}
