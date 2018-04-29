package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

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
                int id = (int)(Math.random()*2+1);
                encounter(id, 100);
            }
        });
        OnClickDungeon2Button onClickDungeon2Button = new OnClickDungeon2Button();
        imageButton2.setOnClickListener(onClickDungeon2Button);
        mainText.setText("ここはボス部屋です");
        position = 3;
        savePosition();
    }
}
