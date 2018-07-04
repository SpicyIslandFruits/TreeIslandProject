package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetEButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10013;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層E通り】\n文章未定");

        OnClickTown1FStreetFButton onClickTown1FStreetFButton = new OnClickTown1FStreetFButton();
        imageButton2.setOnClickListener(onClickTown1FStreetFButton);
        imageButton2Text.setText("F通り");

        OnClickTown1FStreetDButton onClickTown1FStreetDButton = new OnClickTown1FStreetDButton();
        imageButton4.setOnClickListener(onClickTown1FStreetDButton);
        imageButton4Text.setText("D通り");

        OnClickTown1FStreetE_1Button onClickTown1FStreetE_1Button = new OnClickTown1FStreetE_1Button();
        imageButton5.setOnClickListener(onClickTown1FStreetE_1Button);
        imageButton5Text.setText("E_1通り");
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
