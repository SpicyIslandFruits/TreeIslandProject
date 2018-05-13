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
 * アイテムの追加方法はrealmのcreateオブジェクトに名前を渡すだけ。
 * 自分の所持しているアイテムの名前をrealmに保存し、使う際にMakeDataに名前を渡して名前からアイテムのクラスを作成。
 * 使用後にrealmから名前を削除する。という流れ。
 * SuperItem型の変数にクラスを代入するためサブクラスのアイテムで作ったメソッドはスーパークラスにも書く必要がある。
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
