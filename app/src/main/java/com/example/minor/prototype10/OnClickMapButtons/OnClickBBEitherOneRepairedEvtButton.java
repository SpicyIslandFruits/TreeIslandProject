package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

public class OnClickBBEitherOneRepairedEvtButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 27;
        savePosition();
        resetAllButtons();
        mainText.setText("確かに人の気配がしたが...");
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
        imageButton8Text.setText("立ち上がる");
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
