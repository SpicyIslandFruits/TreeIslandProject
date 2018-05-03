package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBedroomButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 13;
        savePosition();
        resetAllButtons();
        mainText.setText("寝室は未実装です。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("睡眠中・・・");
                MainActivity.soundPool.play(MainActivity.cureSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                realm.beginTransaction();
                playerInfo.setHP(playerInfo.getFmaxHP());
                playerInfo.setMP(playerInfo.getFmaxMP());
                realm.commitTransaction();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("\n(HPとMPが回復しました。)");
                        startAllButtons();
                    }
                }, 6100);
            }
        });
        imageButton1Text.setText("一休みしよう。");


        OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
        imageButton8.setOnClickListener(onClickOldMansion1FButton);
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
