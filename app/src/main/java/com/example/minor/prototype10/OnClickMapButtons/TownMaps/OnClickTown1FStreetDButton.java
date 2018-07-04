package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetDButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10008;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層D通り】\n文章未定");

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("武器屋は未実装です。");
            }
        });
        imageButton1Text.setText("武器屋");

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("防具屋は未実装です。");
            }
        });
        imageButton2Text.setText("防具屋");

        OnClickTown1FStreetC_4Button onClickTown1FStreetC_4Button = new OnClickTown1FStreetC_4Button();
        imageButton3.setOnClickListener(onClickTown1FStreetC_4Button);
        imageButton3Text.setText("C_4通り");

        OnClickTown1FStreetEButton onClickTown1FStreetEButton = new OnClickTown1FStreetEButton();
        imageButton4.setOnClickListener(onClickTown1FStreetEButton);
        imageButton4Text.setText("E通り");

        OnClickTown1FStreetCButton onClickTown1FStreetCButton = new OnClickTown1FStreetCButton();
        imageButton5.setOnClickListener(onClickTown1FStreetCButton);
        imageButton5Text.setText("C通り");
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
