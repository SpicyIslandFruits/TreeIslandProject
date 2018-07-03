package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetG_1Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10021;
        onInit();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層G_1通り】\n文章未定");

        imageButton2.setOnClickListener(new OnClickTown1FStreetGButton());
        imageButton2Text.setText("G通り");

        imageButton4.setOnClickListener(new OnClickTown1FStreetG_2Button());
        imageButton4Text.setText("G_2通り");

        imageButton5.setOnClickListener(new OnClickTown1FStreetG_3Button());
        imageButton5Text.setText("G_3通り");
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
