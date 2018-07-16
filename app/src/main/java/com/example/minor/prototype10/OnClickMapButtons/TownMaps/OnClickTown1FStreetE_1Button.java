package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetE_1Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10015;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層E_1通り】\n文章未定");

        OnClickTown1FStreetE_2Button onClickTown1FStreetE_2Button = new OnClickTown1FStreetE_2Button();
        imageButton2.setOnClickListener(onClickTown1FStreetE_2Button);
        imageButton2Text.setText("E_2通り");

        OnClickTown1FStreetEButton onClickTown1FStreetEButton = new OnClickTown1FStreetEButton();
        imageButton5.setOnClickListener(onClickTown1FStreetEButton);
        imageButton5Text.setText("E通り");
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
