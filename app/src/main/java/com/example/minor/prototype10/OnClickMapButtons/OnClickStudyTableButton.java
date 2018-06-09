package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickStudyTableButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 41;
        savePosition();
        resetAllButtons();
        mainText.setText("とても古めかしいデザインだ。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1.setEnabled(false);
                imageButton1Text.setText("");
                imageButton8.setEnabled(false);
                imageButton8Text.setText("");
                mainText.setText("");
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 0.5f);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("戻る");
                        mainText.setText("何も入っていなかった...");
                    }
                }, 1500);
            }
        });
        imageButton1Text.setText("あさる");
        OnClickStudyButton onClickStudyButton = new OnClickStudyButton();
        imageButton8.setOnClickListener(onClickStudyButton);
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
