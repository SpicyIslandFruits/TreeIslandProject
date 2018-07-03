package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetG_2Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10022;
        onInit();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層G_2通り】\n文章未定");

        imageButton1.setOnClickListener(new OnClickTown1FStreetIButton());
        imageButton1Text.setText("I通り");

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("なんかのマップを置きます。未実装");
            }
        });
        imageButton2Text.setText("未定");

        imageButton4.setOnClickListener(new OnClickTown1FStreetG_1Button());
        imageButton4Text.setText("G_1通り");
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
