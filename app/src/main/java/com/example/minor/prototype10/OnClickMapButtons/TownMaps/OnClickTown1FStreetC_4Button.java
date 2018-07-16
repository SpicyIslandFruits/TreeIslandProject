package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetC_4Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10012;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層C_4通り】\n文章未定");

        OnClickTown1FStreetC_2Button onClickTown1FStreetC_2Button = new OnClickTown1FStreetC_2Button();
        imageButton2.setOnClickListener(onClickTown1FStreetC_2Button);
        imageButton2Text.setText("C_2通り");

        OnClickTown1FStreetDButton onClickTown1FStreetDButton = new OnClickTown1FStreetDButton();
        imageButton3.setOnClickListener(onClickTown1FStreetDButton);
        imageButton3Text.setText("D通り");

        OnClickTown1FStreetC_1Button onClickTown1FStreetC_1Button = new OnClickTown1FStreetC_1Button();
        imageButton5.setOnClickListener(onClickTown1FStreetC_1Button);
        imageButton5Text.setText("C_1通り");
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
