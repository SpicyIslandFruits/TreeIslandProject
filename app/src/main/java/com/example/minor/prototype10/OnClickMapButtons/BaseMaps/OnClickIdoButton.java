package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickIdoButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 25;
        onInit();
        mainText.setText("井戸の中に何かあるかもしれない...。\n\n\nなどと思って入ろうとしたものはまさかいないだろう。");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        //選択肢の中から金額を指定して投げ込めるようにします
        OnClickMoneyThrowButton onClickMoneyThrowButton = new OnClickMoneyThrowButton();
        imageButton1.setOnClickListener(onClickMoneyThrowButton);
        imageButton1Text.setText("お金を投げ込む");
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
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
