package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

/**
 * Created by nishiokakota on 2018/04/29.
 */

public class OnClickDungeon2Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        OnClickBossRoomButton onClickBossRoomButton = new OnClickBossRoomButton();
        imageButton1.setOnClickListener(onClickBossRoomButton);
        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton2.setOnClickListener(onClickDungeonButton);
        mainText.setText("ここはダンジョン2Fです");
        position = 4;
        savePosition();
        changeBaseEnemyLevel(60);
        obtainWeapon(0, 100);
        //一時的にここに書いているが、実際はスーパークラスにメソッドとして一定確率で武器を取得するメソッドを書きどこからでも呼び出せるようにする
    }

    @Override
    public void onClick(View v) {
        createMap();
    }
}
