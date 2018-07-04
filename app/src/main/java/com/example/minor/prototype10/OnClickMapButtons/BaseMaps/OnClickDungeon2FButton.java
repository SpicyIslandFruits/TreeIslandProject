package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickDungeon2FButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        position = 4;
        onInit();

        OnClickBossRoomButton onClickBossRoomButton = new OnClickBossRoomButton();
        imageButton1.setOnClickListener(onClickBossRoomButton);

        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton2.setOnClickListener(onClickDungeonButton);
        mainText.setText("ここはダンジョン2Fです");
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
