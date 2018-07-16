package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetC_3Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10011;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層C_3通り】\n文章未定");

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("身分偽造屋は未実装です。");
            }
        });
        imageButton3Text.setText("身分偽造屋");

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("情報屋は未実装です。");
            }
        });
        imageButton4Text.setText("情報屋");

        OnClickTown1FStreetCButton onClickTown1FStreetCButton = new OnClickTown1FStreetCButton();
        imageButton6.setOnClickListener(onClickTown1FStreetCButton);
        imageButton6Text.setText("C通り");
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
