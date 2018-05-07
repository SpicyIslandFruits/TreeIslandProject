package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickDungeon2FButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        position = 4;
        savePosition();
        OnClickBossRoomButton onClickBossRoomButton = new OnClickBossRoomButton();
        imageButton1.setOnClickListener(onClickBossRoomButton);
        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton2.setOnClickListener(onClickDungeonButton);
        mainText.setText("ここはダンジョン2Fです");
        encounter(1, 10);
    }

    @Override
    public void onClick(View v) {
        stopAllButtons();
        createMap();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAllButtons();
            }
        }, 1000);
    }
}
