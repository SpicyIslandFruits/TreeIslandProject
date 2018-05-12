package com.example.minor.prototype10.Items;

import android.content.SharedPreferences;
import com.example.minor.prototype10.Models.ImportantItemId;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * サブクラスで新しいメソッドを作った場合は必ずここにも書いてください。
 */
abstract public class SuperItem {
    public Realm realm;
    public PlayerInfo playerInfo;
    public RealmResults<ImportantItemId> importantItemIds;
    public ImportantItemId importantItemId;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    abstract public String getName();
    abstract public String getInformation();

    public void useMaterial(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        importantItemIds = realm.where(ImportantItemId.class).findAll();
        sharedPreferences = SuperOnClickMapButton.sharedPreferences;
        editor = sharedPreferences.edit();
    }
}
