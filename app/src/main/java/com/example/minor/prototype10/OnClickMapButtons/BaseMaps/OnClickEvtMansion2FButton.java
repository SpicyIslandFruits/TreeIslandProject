package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickEvtMansion2FButton extends SuperOnClickMapButton {
    private void setBack() {
        stopAllButtons();
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("ここに隠れているのだろうか...");
        imageButton1Text.setText("探す");
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
                        mainText.setText("ここにはいないようだ...");
                    }
                }, 1500);
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンを元に戻す処理です。
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
                mainText.setText("あれは何だったんだろう...\nどこへ行ったのだろう...\n謎は深まるばかりだ。");
                imageButton1Text.setText("屋上");
                imageButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setBack();
                    }
                });
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
                imageButton1.setEnabled(true);
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

        //倉庫を確認せずに2階に上がった場合
        if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 0 || sharedPreferences.getInt("oldMansionGhostPosition", 0) == 1) {
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

            OnClickEvtBedroomButton onClickEvtBedroomButton = new OnClickEvtBedroomButton();
            imageButton3.setOnClickListener(onClickEvtBedroomButton);
            imageButton3Text.setText("寝室");
            OnClickEvtMansion1FButton onClickEvtMansion1FButton = new OnClickEvtMansion1FButton();
            imageButton8.setOnClickListener(onClickEvtMansion1FButton);
            imageButton8Text.setText("1階に降りる");
        //イベントを書く後で修正
        }else if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 2){
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton1Text.setText("屋上");

            OnClickEvtStudyButton onClickEvtStudyButton = new OnClickEvtStudyButton();
            imageButton2.setOnClickListener(onClickEvtStudyButton);
            imageButton2Text.setText("書斎");

            OnClickEvtBedroomButton onClickEvtBedroomButton = new OnClickEvtBedroomButton();
            imageButton3.setOnClickListener(onClickEvtBedroomButton);
            imageButton3Text.setText("寝室");
            OnClickEvtMansion1FButton onClickEvtMansion1FButton = new OnClickEvtMansion1FButton();
            imageButton8.setOnClickListener(onClickEvtMansion1FButton);
            imageButton8Text.setText("1階に降りる");
        }
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
