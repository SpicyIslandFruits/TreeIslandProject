package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickOldMansion2FButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 11;
        savePosition();
        resetAllButtons();
        MainActivity.mediaPlayer.start();
        mainText.setText("文章未定");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton1.setOnClickListener(onClickEmptyButton);
        imageButton1Text.setText("屋上");
        OnClickEmptyButton onClickEmptyButton4 = new OnClickEmptyButton();
        imageButton2.setOnClickListener(onClickEmptyButton4);
        imageButton2Text.setText("書斎");
        OnClickBedroomButton onClickBedroomButton = new OnClickBedroomButton();
        imageButton3.setOnClickListener(onClickBedroomButton);
        imageButton3Text.setText("寝室");
        OnClickEmptyButton onClickEmptyButton3 = new OnClickEmptyButton();
        imageButton4.setOnClickListener(onClickEmptyButton3);
        imageButton4Text.setText("倉庫");
        OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
        imageButton8.setOnClickListener(onClickOldMansion1FButton);
        imageButton8Text.setText("1階に降りる");
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
