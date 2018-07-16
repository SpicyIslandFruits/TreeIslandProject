package com.example.minor.prototype10;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.example.minor.prototype10.Activities.MainActivity;

public class AppLifecycleObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onAppPause() {
        MainActivity.mediaPlayer.pause();
    }
}
