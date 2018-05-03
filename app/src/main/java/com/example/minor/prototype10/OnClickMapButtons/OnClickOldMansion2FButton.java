package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickOldMansion2FButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 11;
        savePosition();
        resetAllButtons();
        mainText.setText("部屋の中は真っ暗だ。\n窓には重厚なカーテンがひかれ、室内に明かりはついていない。\nカーテンの隙間から僅かに光の筋がもれていたが、それもかえって暗闇を際立たせるだけだった。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton1.setOnClickListener(onClickEmptyButton);
        imageButton1Text.setText("屋上");
        OnClickEmptyButton onClickEmptyButton2 = new OnClickEmptyButton();
        imageButton2.setOnClickListener(onClickEmptyButton);
        imageButton2Text.setText("寝室");
        OnClickEmptyButton onClickEmptyButton3 = new OnClickEmptyButton();
        imageButton3.setOnClickListener(onClickEmptyButton);
        imageButton3Text.setText("倉庫");
        OnClickEmptyButton onClickEmptyButton4 = new OnClickEmptyButton();
        imageButton4.setOnClickListener(onClickEmptyButton);
        imageButton4Text.setText("書斎");
        OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
        imageButton8.setOnClickListener(onClickOldMansion1FButton);
        imageButton8Text.setText("1Fに降りる");
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
