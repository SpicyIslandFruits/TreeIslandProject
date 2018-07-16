package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetF_1Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10017;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層F_1通り】\n文章未定");

        OnClickTown1FStreetF_2Button onClickTown1FStreetF_2Button = new OnClickTown1FStreetF_2Button();
        imageButton2.setOnClickListener(onClickTown1FStreetF_2Button);
        imageButton2Text.setText("F_2通り");

        OnClickTown1FStreetFButton onClickTown1FStreetFButton = new OnClickTown1FStreetFButton();
        imageButton4.setOnClickListener(onClickTown1FStreetFButton);
        imageButton4Text.setText("F通り");
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
