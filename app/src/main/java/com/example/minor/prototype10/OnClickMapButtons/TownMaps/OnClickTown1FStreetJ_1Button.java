package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetJ_1Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10026;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層J_1通り】\n文章未定");

        imageButton2.setOnClickListener(new OnClickTown1FStreetJButton());
        imageButton2Text.setText("J通り");

        imageButton3.setOnClickListener(new OnClickTown1FStreetJ_2Button());
        imageButton3Text.setText("J_2通り");

        imageButton4.setOnClickListener(new OnClickTown1FStreetJ_3Button());
        imageButton4Text.setText("J_3通り");
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
