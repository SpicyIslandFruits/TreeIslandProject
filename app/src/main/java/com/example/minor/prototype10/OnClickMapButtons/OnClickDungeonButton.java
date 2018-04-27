package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.AbnormalStates;
import com.example.minor.prototype10.MakeWeaponRealmObject;
import com.example.minor.prototype10.Models.WeaponId;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmResults;

//マップの階層が深くなる時はbaseEnemyLevelを編集してください
//onClickListenerを登録してください
//これからテキストを三つに増やす
//マップの名前を表示するためのテキスト、その他の文章を表示するためのテキスト、イベントを表示するためのテキスト
//一時的にメインテキストに武器取得を表示しています
//スーパークラスに一定確率で武器を取得するメソッドを追加します
//そこに取得に成功した場合のif処理を書く予定ですが、一時的にここにif文を書いています
//敵とのエンカウントをさせたい場合はencounterメソッドを実行してください、エンカウントする敵のidと確率を引数に入れてください
public class OnClickDungeonButton extends SuperOnClickMapButton{
    @Override
    public void onClick(View v) {
        createMap();
    }
    public void createMap(){
        OnClickBossRoomButton onClickBossRoomButton = new OnClickBossRoomButton();
        imageButton1.setOnClickListener(onClickBossRoomButton);
        OnClickTownButton onClickTownButton = new OnClickTownButton();
        imageButton2.setOnClickListener(onClickTownButton);
        mainText.setText("ここはダンジョンです");
        position = 2;
        savePosition();
        //一時的にここに書いているが、実際はスーパークラスにメソッドとして一定確率で武器を取得するメソッドを書きどこからでも呼び出せるようにする
        MakeWeaponRealmObject makeWeaponRealmObject = new MakeWeaponRealmObject();
        if(makeWeaponRealmObject.createNewWeapon(1)){
            mainText.setText("武器を取得しました");
        };
    }
}
