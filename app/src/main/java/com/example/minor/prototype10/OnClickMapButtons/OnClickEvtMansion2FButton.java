package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickEvtMansion2FButton extends SuperOnClickMapButton {
    private void setBack() {
        stopAllButtons();
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("ここにはいないようだ...");
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンを元に戻す処理です。
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
                mainText.setText("あれは何だったんだろう...\nどこへ行ったのだろう...\n謎は深まるばかりだ。");
                imageButton1Text.setText("屋上");
                imageButton2Text.setText("書斎");
                imageButton3Text.setText("寝室");
                imageButton8Text.setText("一階に降りる");
                imageButton8.setEnabled(false);
                OnClickEvtMansion1FButton onClickEvtMansion1FButton = new OnClickEvtMansion1FButton();
                imageButton8.setOnClickListener(onClickEvtMansion1FButton);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startAllButtons();
                    }
                }, 1000);
            }
        });
        imageButton8Text.setText("戻る");
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageButton8.setEnabled(true);
            }
        }, 1000);
    }

    @Override
    public void createMap() {
        position = 35;
        savePosition();
        resetAllButtons();
        MainActivity.mediaPlayer.start();
        mainText.setText("二階にいるのだろうか...");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);

        //井戸を確認せず入った場合
        //if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 0) {
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton1Text.setText("屋上");

            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton2Text.setText("書斎");

            imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton3Text.setText("寝室");
            OnClickEvtMansion1FButton onClickEvtMansion1FButton = new OnClickEvtMansion1FButton();
            imageButton8.setOnClickListener(onClickEvtMansion1FButton);
            imageButton8Text.setText("1階に降りる");
        //}else if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 1){
        //ここにイベントが発生する場合の処理書きます
        //}
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
