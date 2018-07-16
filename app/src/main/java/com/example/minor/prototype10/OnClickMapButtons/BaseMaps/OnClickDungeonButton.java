package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

/**
 * マップの階層が深くなる時はbaseEnemyLevelを編集してください
 * onClickListenerを登録してください
 * これからテキストを三つに増やす
 * マップの名前を表示するためのテキスト、その他の文章を表示するためのテキスト、イベントを表示するためのテキスト
 * 一時的にメインテキストに武器取得を表示しています
 * スーパークラスに一定確率で武器を取得するメソッドを追加します
 * そこに取得に成功した場合のif処理を書く予定ですが、一時的にここにif文を書いています
 * 敵とのエンカウントをさせたい場合はencounterメソッドを実行してください、エンカウントする敵のidと確率を引数に入れてください
 * savePositionメソッドを必ず実行してください
 * changeBaseEnemyLevelをするときはsavePositionの後に実行してください
 * changeBaseEnemyLevelとobtainWeaponまたはencounterを同じマップでどちらも実行するときはchangeBaseEnemyLevelの後に実行してください
 */
public class OnClickDungeonButton extends SuperOnClickMapButton {
    public void createMap(){
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        position = 2;
        onInit();
        OnClickDungeon2FButton onClickDungeon2FButton = new OnClickDungeon2FButton();
        imageButton1.setOnClickListener(onClickDungeon2FButton);
        OnClickTownButton onClickTownButton = new OnClickTownButton();
        imageButton2.setOnClickListener(onClickTownButton);
        mainText.setText("ここはダンジョンです");
        changeBaseEnemyLevel(50);
        encounter(0, 10);
        obtainAmulet("SampleAmulet", 100);
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
