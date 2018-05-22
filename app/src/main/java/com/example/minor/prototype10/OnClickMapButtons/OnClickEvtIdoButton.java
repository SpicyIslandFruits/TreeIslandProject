package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickEvtIdoButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 32;
        savePosition();
        resetAllButtons();
        mainText.setText("井戸の中に隠れているのだろうか...");
        MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickEvtMoneyThrowButton onClickEvtMoneyThrowButton = new OnClickEvtMoneyThrowButton();
        imageButton1.setOnClickListener(onClickEvtMoneyThrowButton);
        imageButton1Text.setText("お金を投げ込む");
        OnClickBBBothRepairedEvtButton onClickBBBothRepairedEvtButton = new OnClickBBBothRepairedEvtButton();
        imageButton8.setOnClickListener(onClickBBBothRepairedEvtButton);
        imageButton8Text.setText("やめる");
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
