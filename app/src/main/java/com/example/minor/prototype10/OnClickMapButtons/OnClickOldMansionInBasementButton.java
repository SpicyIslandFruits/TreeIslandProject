package com.example.minor.prototype10.OnClickMapButtons;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.R;

import java.util.logging.Handler;

public class OnClickOldMansionInBasementButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        startAllButtons();
        int bgmId = 5;
        mediaPlayer = MediaPlayer.create(mMain, R.raw.basement_sound);
        audioPlay(mediaPlayer, bgmId);
        mainText.setText("地下室の中です。文章未定");
        //日記、卵についての資料、悪魔についての研究資料、嵐についての研究資料
        imageButton1Text.setText("資料1");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("資料1の内容");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("閉じる");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                stopAllButtons();
                                mainText.setText("");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createMap();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 800);
            }
        });
        imageButton2Text.setText("資料2");
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("資料2の内容");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("閉じる");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                stopAllButtons();
                                mainText.setText("");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createMap();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 800);
            }
        });
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
        imageButton8Text.setText("出る");
    }

    @Override
    public void onClick(View v) {
        position = 45;
        savePosition();
        resetAllButtons();
        stopAllButtons();
        int bgmId = 4;
        mediaPlayer = MediaPlayer.create(mMain, R.raw.noise);
        audioPlay(mediaPlayer, bgmId);
        MainActivity.soundPool.play(MainActivity.walkGymnasiumSound, 5.0f, 5.0f, 1, 0, 0.8f);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.soundPool.play(MainActivity.doorOpenSound, 1.0f, 1.0f, 1, 0, 0.8f);
            }
        }, 4500);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createMap();
            }
        }, 5500);
    }
}
