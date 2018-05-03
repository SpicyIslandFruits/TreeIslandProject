package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickRooftopButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 12;
        savePosition();
        resetAllButtons();
        mainText.setText("屋上は未実装です。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickOldMansion2FButton onClickOldMansion2FButton = new OnClickOldMansion2FButton();
        imageButton8.setOnClickListener(onClickOldMansion2FButton);
        imageButton8Text.setText("戻る");
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
