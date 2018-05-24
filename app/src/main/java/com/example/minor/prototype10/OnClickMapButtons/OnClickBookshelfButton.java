package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBookshelfButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 39;
        savePosition();
        resetAllButtons();
        mainText.setText("古そうな書物が並んでいる...");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1Text.setText("書物1を読む");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("書物1の内容");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                        imageButton8.setOnClickListener(onClickBookshelfButton);
                    }
                }, 800);
            }
        });
        imageButton2Text.setText("書物2を読む");
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("書物2の内容");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                        imageButton8.setOnClickListener(onClickBookshelfButton);
                    }
                }, 800);
            }
        });
        imageButton3Text.setText("書物3を読む");
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("書物3の内容");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                        imageButton8.setOnClickListener(onClickBookshelfButton);
                    }
                }, 800);
            }
        });
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
