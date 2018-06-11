package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickRooftopButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 12;
        savePosition();
        resetAllButtons();
        mainText.setText("寒い...。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);

        imageButton1Text.setText("夜空を見上げる");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1.setEnabled(false);
                imageButton7.setEnabled(false);
                MainActivity.soundPool.play(MainActivity.oldMansionNightSkySound, 1.0f, 1.0f, 1, 0, 1);
                imageButton8Text.setText("やめる");
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                        imageButton1Text.setText("夜空を見上げる");
                        imageButton7Text.setText("飛び降りる");
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imageButton1.setEnabled(true);
                                imageButton7.setEnabled(true);
                                imageButton8.setOnClickListener(new OnClickOldMansion2FButton());
                            }
                        }, 1000);
                        imageButton8Text.setText("戻る");
                        mainText.setText("お前は空を見上げるのをやめた。");
                    }
                });
                imageButton1Text.setText("");
                imageButton7Text.setText("");
                mainText.setText("お前は空を見上げた・・・。\n余分な明かりがないせいか、空気が汚れていないせいか、星の多さに驚かされる。\n人々の営みとは無縁のように輝く星々はとても壮大だった。");
            }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllButtons();
                MainActivity.mediaPlayer.pause();
                MainActivity.soundPool.play(MainActivity.oldMansionSleepSound, 1.0f, 1.0f, 1, 0, 1);
                //ゲームオーバー画面に遷移する予定です。ラスボスが主人公を助ける場面です。
                mainText.setText("何もかもおしまいだ。\nお前はすべてを失った、もう思い残すことは何もない。\n\n薄れゆく意識の中、黒い人影があらわれて...。");
                realm.beginTransaction();
                playerInfo.setPlayerSuicideFlag(true);
                playerInfo.setPosition(17);
                realm.commitTransaction();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mMain.finishAndRemoveTask();
                    }
                }, 6100);
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
