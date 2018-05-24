package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickEvtBackDoorButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 35;
        savePosition();
        resetAllButtons();
        mainText.setText("もう一度庭を確認しよう...");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickBBBothRepairedEvtButton onClickBBBothRepairedEvtButton = new OnClickBBBothRepairedEvtButton();
        imageButton1.setOnClickListener(onClickBBBothRepairedEvtButton);
        imageButton1Text.setText("外に出る");
        OnClickEvtMansion1FButton onClickEvtMansion1FButton = new OnClickEvtMansion1FButton();
        imageButton8.setOnClickListener(onClickEvtMansion1FButton);
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
