package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.Models.PlayerInfo;

import io.realm.Realm;

//ダンジョンのコメントを参照
public class OnClickInnButton extends SuperOnClickMapButton{
    @Override
    public void onClick(View v) {
        createMap();
    }
    public void createMap(){
        OnClickTownButton onClickTownButton = new OnClickTownButton();
        imageButton1.setOnClickListener(onClickTownButton);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {mainText.setText("宿泊しました。体力とmpが全回復しました。敵の強さをリセットしました。状態異常を回復しました。");
                stopAllButtons();
                realm.beginTransaction();
                playerInfo.setHP(playerInfo.getFmaxHP());
                playerInfo.setMP(playerInfo.getFmaxMP());
                playerInfo.setAdditionalEnemyLevel(0);
                playerInfo.setPoisonFlag(false);
                playerInfo.setBleedingFlag(false);
                realm.commitTransaction();
                startAllButtons();
            }
        });
        mainText.setText("ここは宿です");
        position = 0;
        savePosition();
    }
}
