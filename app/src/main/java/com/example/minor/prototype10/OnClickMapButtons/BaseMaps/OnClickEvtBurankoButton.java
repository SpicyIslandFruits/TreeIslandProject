package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickEvtBurankoButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 30;
        savePosition();
        resetAllButtons();
        mainText.setText("もう一度座ればまた現れるだろうか...");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickEvtBurankoNisuwaruButton onClickEvtBurankoNisuwaruButton = new OnClickEvtBurankoNisuwaruButton();
        imageButton1.setOnClickListener(onClickEvtBurankoNisuwaruButton);
        imageButton1Text.setText("座る");
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
