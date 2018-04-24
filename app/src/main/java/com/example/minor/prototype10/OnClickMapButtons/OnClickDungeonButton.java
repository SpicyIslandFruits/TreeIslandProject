package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MakeWeaponRealmObject;
import com.example.minor.prototype10.Models.WeaponId;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmResults;

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
        MakeWeaponRealmObject makeWeaponRealmObject = new MakeWeaponRealmObject();
        if(makeWeaponRealmObject.createNewWeapon(1)){
            mainText.setText("武器を取得しました");
        };

    }
}
