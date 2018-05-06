package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickRooftopButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 12;
        savePosition();
        resetAllButtons();
        mainText.setText("お前は屋上に登った。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);

        imageButton1Text.setText("夜空を見上げる");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAllButtons();
                imageButton1.setEnabled(false);
                imageButton7.setEnabled(false);
                MainActivity.soundPool.play(MainActivity.oldMansionNightSkySound, 1.0f, 1.0f, 1, 0, 1);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton8Text.setText("やめる");
                        startAllButtons();
                    }
                }, 1000);
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                        imageButton1.setEnabled(true);
                        imageButton7.setEnabled(true);
                        imageButton1Text.setText("夜空を見上げる");
                        imageButton7Text.setText("飛び降りる");
                        imageButton8Text.setText("戻る");
                        imageButton8.setOnClickListener(new OnClickOldMansion2FButton());
                        mainText.setText("お前は空を見上げるのをやめた。");
                    }
                });
                imageButton8Text.setText("");
                imageButton1Text.setText("");
                imageButton7Text.setText("");
                mainText.setText("お前は空を見上げた。\n余分な明かりがないせいか、空気が汚れていないせいか、お前は星の多さに驚かされる。\n人々の営みとは無縁のように輝く星々は、とても超越的であった。");
            }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllButtons();
                //ゲームオーバー画面に遷移する予定です。
                mainText.setText("お前は死んでしまった。");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mMain.finishAndRemoveTask();
                    }
                }, 2000);
            }
        });

        imageButton7Text.setText("飛び降りる");
        OnClickOldMansion2FButton onClickOldMansion2FButton = new OnClickOldMansion2FButton();
        imageButton8.setOnClickListener(onClickOldMansion2FButton);
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
