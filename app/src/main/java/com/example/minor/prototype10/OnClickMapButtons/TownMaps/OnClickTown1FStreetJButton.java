package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetJButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10025;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層J通り】\n文章未定");

        imageButton2.setOnClickListener(new OnClickTown1FStreetJ_1Button());
        imageButton2Text.setText("J_1通り");

        imageButton3.setOnClickListener(new OnClickTown1FStreetKButton());
        imageButton3Text.setText("K通り");

        imageButton4.setOnClickListener(new OnClickTown1FStreetIButton());
        imageButton4Text.setText("I通り");

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("なんかのマップと接続します。");
            }
        });
        imageButton6Text.setText("未定");
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
