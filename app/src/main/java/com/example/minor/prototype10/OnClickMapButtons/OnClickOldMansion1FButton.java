package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;
import com.example.minor.prototype10.MainActivity;

public class OnClickOldMansion1FButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        resetAllButtons();
        position = 8;
        savePosition();
        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton1.setOnClickListener(onClickEmptyButton);
        imageButton1Text.setText("キッチン");
        OnClickEmptyButton onClickEmptyButton1 = new OnClickEmptyButton();
        imageButton2.setOnClickListener(onClickEmptyButton1);
        imageButton2Text.setText("風呂");
        OnClickEmptyButton onClickEmptyButton2 = new OnClickEmptyButton();
        imageButton3.setOnClickListener(onClickEmptyButton2);
        imageButton1Text.setText("2階へ上がる");
        OnClickEmptyButton onClickEmptyButton3 = new OnClickEmptyButton();
        imageButton7.setOnClickListener(onClickEmptyButton3);
        imageButton7Text.setText("部屋の隅");
        OnClickPassButton onClickPassButton = new OnClickPassButton();
        imageButton8.setOnClickListener(onClickPassButton);
        imageButton8Text.setText("出る");
        mainText.setText("お前は屋敷の中へと入っていった…。\n薄暗い部屋の中、壁の汚れた模様が不気味な雰囲気を醸し出している。\nとても陰気な雰囲気だ、しかし不思議とお前の心は安らいだ。");
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
