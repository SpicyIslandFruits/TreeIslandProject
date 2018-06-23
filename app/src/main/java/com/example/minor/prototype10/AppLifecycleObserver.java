package com.example.minor.prototype10;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public class AppLifecycleObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onAppPause() {
        MainActivity.mediaPlayer.pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onAppResume() {
        MainActivity.mediaPlayer.start();
    }
}
