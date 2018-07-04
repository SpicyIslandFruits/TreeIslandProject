package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;
import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetA_1Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10004;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層A_1通り】\n文章未定");

        OnClickTown1FStreetAButton onClickTown1FStreetAButton = new OnClickTown1FStreetAButton();
        imageButton1.setOnClickListener(onClickTown1FStreetAButton);
        imageButton1Text.setText("A通り");

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("酒場は未実装です。使いまわしができるように作ります。");
            }
        });
        imageButton2Text.setText("酒場");

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("薬屋は未実装です。使いまわしができるように作ります。");
            }
        });
        imageButton3Text.setText("薬屋");

        OnClickTown1FStreetBButton onClickTown1FStreetBButton = new OnClickTown1FStreetBButton();
        imageButton4.setOnClickListener(onClickTown1FStreetBButton);
        imageButton4Text.setText("B通り");
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
