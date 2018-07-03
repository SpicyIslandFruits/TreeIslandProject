package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetFButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10014;
        onInit();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層F通り】\n文章未定");

        OnClickTown1FStreetEButton onClickTown1FStreetEButton = new OnClickTown1FStreetEButton();
        imageButton2.setOnClickListener(onClickTown1FStreetEButton);
        imageButton2Text.setText("E通り");

        OnClickTown1FStreetE_2Button onClickTown1FStreetE_2Button = new OnClickTown1FStreetE_2Button();
        imageButton3.setOnClickListener(onClickTown1FStreetE_2Button);
        imageButton3Text.setText("E_2通り");

        OnClickTown1FStreetF_1Button onClickTown1FStreetF_1Button = new OnClickTown1FStreetF_1Button();
        imageButton4.setOnClickListener(onClickTown1FStreetF_1Button);
        imageButton4Text.setText("F_1通り");

        OnClickTown1FStreetGButton onClickTown1FStreetGButton = new OnClickTown1FStreetGButton();
        imageButton5.setOnClickListener(onClickTown1FStreetGButton);
        imageButton5Text.setText("G通り");
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
