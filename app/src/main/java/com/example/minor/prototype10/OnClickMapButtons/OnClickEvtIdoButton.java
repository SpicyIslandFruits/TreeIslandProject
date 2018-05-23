package com.example.minor.prototype10.OnClickMapButtons;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.R;

public class OnClickEvtIdoButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 32;
        savePosition();
        resetAllButtons();
        mainText.setText("井戸の中に隠れているかもしれない...");
        MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("");
                stopAllButtons();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.soundPool.play(MainActivity.stoneWaterDropSound, 1.0f, 1.0f, 1, 0, 1);
                    }
                }, 300);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("お前は石を投げ込んだ、果たしてここにいるのだろうか。");
                    }
                }, 1000);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.soundPool.play(MainActivity.yuureiMituketaSound, 1.0f, 1.0f, 1, 0, 1);
                    }
                }, 2500);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("何かが飛び出してきて屋敷の中へと入っていった！");
                        startAllButtons();
                        imageButton1.setOnClickListener(null);
                        imageButton8Text.setText("追いかける");
                        OnClickEvtMansion1FButton onClickEvtMansion1FButton = new OnClickEvtMansion1FButton();
                        imageButton8.setOnClickListener(onClickEvtMansion1FButton);
                    }
                }, 3000);
            }
        });
        imageButton1Text.setText("石を投げ込む");
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
