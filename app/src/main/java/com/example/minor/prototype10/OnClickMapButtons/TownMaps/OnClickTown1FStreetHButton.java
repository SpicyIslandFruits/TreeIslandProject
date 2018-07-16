package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetHButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10020;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層H通り】\n文章未定");

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("なんかのマップと接続します。");
            }
        });
        imageButton1Text.setText("未定");

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("なんかのマップと接続します。");
            }
        });
        imageButton3Text.setText("未定");

        imageButton5.setOnClickListener(new OnClickTown1FStreetIButton());
        imageButton5Text.setText("I通り");

        imageButton6.setOnClickListener(new OnClickTown1FStreetGButton());
        imageButton6Text.setText("G通り");
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
