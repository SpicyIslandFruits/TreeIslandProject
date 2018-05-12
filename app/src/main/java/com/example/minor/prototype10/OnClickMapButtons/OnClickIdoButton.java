package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickIdoButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 25;
        savePosition();
        resetAllButtons();
        mainText.setText("井戸の中に何かあるかもしれない...。\n\n\nなどと思って入ろうとしたものはまさかいないだろう。");
        MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton1.setOnClickListener(onClickEmptyButton);
        imageButton1Text.setText("お金を投げ込む");
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
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
