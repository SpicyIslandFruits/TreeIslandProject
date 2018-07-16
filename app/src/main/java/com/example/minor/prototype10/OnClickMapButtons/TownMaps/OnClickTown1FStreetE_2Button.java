package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetE_2Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10016;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層E_2通り】\n文章未定");

        OnClickTown1FStreetE_1Button onClickTown1FStreetE_1Button = new OnClickTown1FStreetE_1Button();
        imageButton2.setOnClickListener(onClickTown1FStreetE_1Button);
        imageButton2Text.setText("E_1通り");

        OnClickTown1FStreetFButton onClickTown1FStreetFButton = new OnClickTown1FStreetFButton();
        imageButton3.setOnClickListener(onClickTown1FStreetFButton);
        imageButton3Text.setText("F通り");

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("豪邸は未実装です。");
            }
        });
        imageButton5Text.setText("豪邸");
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
