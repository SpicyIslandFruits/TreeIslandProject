package com.example.minor.prototype10;

import android.app.Application;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Realmの初期データの作成方法が分かれば編集します
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        AppLifecycleObserver appLifecycleObserver = new AppLifecycleObserver();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(appLifecycleObserver);
    }
}
