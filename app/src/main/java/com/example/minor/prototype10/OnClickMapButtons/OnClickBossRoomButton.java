package com.example.minor.prototype10.OnClickMapButtons;

import android.content.Intent;
import android.view.View;

import com.example.minor.prototype10.BattleActivity;

//ダンジョンのコメント参照
public class OnClickBossRoomButton extends SuperOnClickMapButton{
    @Override
    public void onClick(View v) {
        createMap();
    }
    public void createMap(){
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mMain, BattleActivity.class);
                intent.putExtra("EnemyId", 1);
                mMain.startActivity(intent);

            }
        });
        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton2.setOnClickListener(onClickDungeonButton);
        mainText.setText("ここはボス部屋です");
        position = 3;
        savePosition();
    }
}
