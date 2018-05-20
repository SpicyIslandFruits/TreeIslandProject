package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBurankoButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 23;
        savePosition();
        resetAllButtons();
        mainText.setText("文章未定");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickBurankoNisuwaruButton onClickBurankoNisuwaruButton = new OnClickBurankoNisuwaruButton();
        imageButton1.setOnClickListener(onClickBurankoNisuwaruButton);
        imageButton1Text.setText("座る");
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