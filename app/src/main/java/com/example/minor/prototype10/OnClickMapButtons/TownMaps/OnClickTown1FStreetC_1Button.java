package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetC_1Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10009;
        savePosition();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層C_1通り】\n文章未定");

        OnClickTown1FStreetCButton onClickTown1FStreetCButton = new OnClickTown1FStreetCButton();
        imageButton1.setOnClickListener(onClickTown1FStreetCButton);
        imageButton1Text.setText("C通り");

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("大男は未実装です。");
            }
        });
        imageButton3Text.setText("大男");

        OnClickTown1FStreetC_4Button onClickTown1FStreetC_4Button = new OnClickTown1FStreetC_4Button();
        imageButton5.setOnClickListener(onClickTown1FStreetC_4Button);
        imageButton5Text.setText("C_4通り");
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
