package com.example.minor.prototype10.OnClickMapButtons;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickEvtMansion1FButton extends SuperOnClickMapButton {
    private void setBack(){
        stopAllButtons();
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("ここにはいないようだ...");
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンを元に戻す処理です。
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
                mainText.setText("あれは何だったんだろう...\nどこへ行ったのだろう...\n謎は深まるばかりだ。");
                imageButton1Text.setText("2階へ上がる");
                imageButton2Text.setText("浴室");
                imageButton3Text.setText("台所");
                imageButton4Text.setText("倉庫");
                imageButton7Text.setText("裏口");
                imageButton8Text.setText("出る");
                imageButton8.setEnabled(false);
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainText.setText("屋敷の外へ出たとは考えにくい...\nもう少し探してみよう。");
                    }
                });
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
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        resetAllButtons();
        position = 33;
        savePosition();

        //屋敷の一階でなにかが起こるときはif文を実装します。下のelse文の中にイベントを書きます
        //井戸を確認せず入った場合
        //if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 0) {
            OnClickEvtMansion2FButton onClickEvtMansion2FButton = new OnClickEvtMansion2FButton();
            imageButton1.setOnClickListener(onClickEvtMansion2FButton);
            imageButton1Text.setText("2階へ上がる");
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton2Text.setText("浴室");
            imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton3Text.setText("台所");
            imageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton4Text.setText("倉庫");
            OnClickEvtBackDoorButton onClickEvtBackDoorButton = new OnClickEvtBackDoorButton();
            imageButton7.setOnClickListener(onClickEvtBackDoorButton);
            imageButton7Text.setText("裏口");
            imageButton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                    mainText.setText("屋敷の外へ出たとは考えにくい...\nもう少し探してみよう。");
                }
            });
            imageButton8Text.setText("出る");
        //}else if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 1){
            //ここにイベントが発生する場合の処理書きます
        //}

        mainText.setText("あれは何だったんだろう...\nどこへ行ったのだろう...\n謎は深まるばかりだ。");
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
