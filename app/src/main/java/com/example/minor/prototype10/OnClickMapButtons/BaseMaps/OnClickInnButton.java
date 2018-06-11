package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

//ダンジョンのコメントを参照
public class OnClickInnButton extends SuperOnClickMapButton {
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
    public void createMap(){
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickTownButton onClickTownButton = new OnClickTownButton();
        imageButton1.setOnClickListener(onClickTownButton);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("宿泊中・・・");
                MainActivity.soundPool.play(MainActivity.cureSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                realm.beginTransaction();
                playerInfo.setHP(playerInfo.getFmaxHP());
                playerInfo.setMP(playerInfo.getFmaxMP());
                playerInfo.setAdditionalEnemyLevel(0);
                playerInfo.setPoisonFlag(false);
                playerInfo.setBleedingFlag(false);
                realm.commitTransaction();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("宿泊しました。体力とmpが全回復しました。敵の強さをリセットしました。状態異常を回復しました。");
                        startAllButtons();
                    }
                }, 6100);
            }
        });
        mainText.setText("ここは宿です");
        position = 0;
        savePosition();
    }
}
