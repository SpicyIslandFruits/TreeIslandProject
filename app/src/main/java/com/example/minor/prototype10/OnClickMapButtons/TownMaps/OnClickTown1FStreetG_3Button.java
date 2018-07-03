package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetG_3Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10023;
        onInit();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層G_3通り】\n文章未定");

        imageButton3.setOnClickListener(new OnClickTown1FStreetIButton());
        imageButton3Text.setText("I通り");

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("なんかのマップを置きます。未実装");
            }
        });
        imageButton2Text.setText("未定");

        imageButton5.setOnClickListener(new OnClickTown1FStreetG_1Button());
        imageButton5Text.setText("G_1通り");
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
