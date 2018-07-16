package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetIButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10024;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層I通り】\n文章未定");

        imageButton1.setOnClickListener(new OnClickTown1FStreetG_2Button());
        imageButton1Text.setText("G_2通り");

        imageButton3.setOnClickListener(new OnClickTown1FStreetG_3Button());
        imageButton3Text.setText("G_3通り");

        imageButton4.setOnClickListener(new OnClickTown1FStreetJButton());
        imageButton4Text.setText("J通り");

        imageButton5.setOnClickListener(new OnClickTown1FStreetHButton());
        imageButton5Text.setText("H通り");

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("なんかのマップと接続します。");
            }
        });
        imageButton6Text.setText("未定");
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
