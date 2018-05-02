package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickOldMansionButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.sampleSound1, 1.0f, 1.0f, 1, 0, 1);
        position = 6;
        savePosition();
        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton1.setOnClickListener(onClickEmptyButton);
        imageButton1Text.setText("中に入る");
        OnClickPassButton onClickPassButton = new OnClickPassButton();
        imageButton2.setOnClickListener(onClickPassButton);
        imageButton2Text.setText("やめる");
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
