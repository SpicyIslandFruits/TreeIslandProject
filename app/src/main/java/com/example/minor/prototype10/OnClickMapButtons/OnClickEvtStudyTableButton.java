package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickEvtStudyTableButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 42;
        savePosition();
        resetAllButtons();
        stopAllButtons();
        OnClickEvtStudyButton onClickEvtStudyButton = new OnClickEvtStudyButton();
        imageButton8.setOnClickListener(onClickEvtStudyButton);
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 0.5f);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageButton8.setEnabled(true);
                imageButton8Text.setText("やめる");
                mainText.setText("何かの痕跡は見つからなかった...");
            }
        }, 1500);
    }

    @Override
    public void onClick(View v) {
        createMap();
    }
}
