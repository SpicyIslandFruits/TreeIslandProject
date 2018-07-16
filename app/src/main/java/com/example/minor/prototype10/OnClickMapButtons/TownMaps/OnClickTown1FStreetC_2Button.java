package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetC_2Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10010;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層C_2通り】\n文章未定");

        OnClickTown1FStreetC_4Button onClickTown1FStreetC_4Button = new OnClickTown1FStreetC_4Button();
        imageButton2.setOnClickListener(onClickTown1FStreetC_4Button);
        imageButton2Text.setText("C_4通り");

        OnClickTown1FStreetCButton onClickTown1FStreetCButton = new OnClickTown1FStreetCButton();
        imageButton3.setOnClickListener(onClickTown1FStreetCButton);
        imageButton3Text.setText("C通り");

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("ゴミ捨て場は未実装です。主人公のスタート地点です。");
            }
        });
        imageButton4Text.setText("ゴミ捨て場");
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
