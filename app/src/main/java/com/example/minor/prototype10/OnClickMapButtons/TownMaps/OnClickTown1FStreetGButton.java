package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetGButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10019;
        savePosition();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層G通り】\n文章未定");

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("神社は未実装です。");
            }
        });
        imageButton1Text.setText("神社");

        OnClickTown1FStreetF_2Button onClickTown1FStreetF_2Button = new OnClickTown1FStreetF_2Button();
        imageButton3.setOnClickListener(onClickTown1FStreetF_2Button);
        imageButton3Text.setText("F_2通り");

        OnClickTown1FStreetFButton onClickTown1FStreetFButton = new OnClickTown1FStreetFButton();
        imageButton5.setOnClickListener(onClickTown1FStreetFButton);
        imageButton5Text.setText("F通り");

        //これからはインナークラスを使って書きます
        imageButton6.setOnClickListener(new OnClickTown1FStreetHButton());
        imageButton6Text.setText("H通り");

        //これからはインナークラスを使って書きます
        imageButton2.setOnClickListener(new OnClickTown1FStreetG_1Button());
        imageButton2Text.setText("G_1通り");

        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("商店街は未実装です。入り口になっていて、入るとランダムに店が幾つか生成されます。");
            }
        });
        imageButton8Text.setText("商店街");
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
