package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetF_2Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10018;
        savePosition();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層F_2通り】\n文章未定");

        OnClickTown1FStreetF_1Button onClickTown1FStreetF_1Button = new OnClickTown1FStreetF_1Button();
        imageButton2.setOnClickListener(onClickTown1FStreetF_1Button);
        imageButton2Text.setText("F_1通り");

        OnClickTown1FStreetGButton onClickTown1FStreetGButton = new OnClickTown1FStreetGButton();
        imageButton3.setOnClickListener(onClickTown1FStreetGButton);
        imageButton3Text.setText("G通り");

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("教会は未実装です。");
            }
        });
        imageButton5Text.setText("教会");
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
