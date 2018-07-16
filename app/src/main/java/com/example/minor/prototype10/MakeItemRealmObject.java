package com.example.minor.prototype10;

import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.Models.AmuletName;
import com.example.minor.prototype10.Models.ImportantItemName;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.RecoveryItemName;

import io.realm.Realm;

public class MakeItemRealmObject {
    private PlayerInfo playerInfo;
    private Realm realm;
    private RecoveryItemName recoveryItemName;
    private AmuletName amuletName;
    private ImportantItemName importantItemName;
    private MakeData makeData;
    private SuperItem superItem;

    /**
     * recoveryItemを作るメソッドです。
     * TODO: 残りの種類のアイテムについても作成します。
     */
    public void createNewRecoveryItem(String recoveryItemName){
        realm = Realm.getDefaultInstance();
        makeData = new MakeData();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        superItem = makeData.makeItemFromName(recoveryItemName);

        realm.beginTransaction();
        this.recoveryItemName = realm.createObject(RecoveryItemName.class);
        this.recoveryItemName.setItemName(superItem.getName());
        playerInfo.getEquippedRecoveryItems().add(this.recoveryItemName);
        realm.commitTransaction();
        realm.close();
    }

    public void createNewAmulet(String amuletName){
        realm = Realm.getDefaultInstance();
        makeData = new MakeData();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        superItem = makeData.makeItemFromName(amuletName);

        realm.beginTransaction();
        this.amuletName = realm.createObject(AmuletName.class);
        this.amuletName.setAmuletName(superItem.getName());
        realm.commitTransaction();
        realm.close();
    }

    public void createNewImportantItem(String importantItemName){
        realm = Realm.getDefaultInstance();
        makeData = new MakeData();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        superItem = makeData.makeItemFromName(importantItemName);

        realm.beginTransaction();
        this.importantItemName = realm.createObject(ImportantItemName.class);
        this.importantItemName.setItemName(superItem.getName());
        realm.commitTransaction();
        realm.close();
    }

    /**
     * TODO: 最後の倉庫の作成時に実装します。
     */
    public void createNewOtherItem(){

    }
}
