package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

public class OnClickBBEitherOneRepairedEvtButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 27;
        savePosition();
        resetAllButtons();
        mainText.setText("イベント未定");
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
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
