package com.example.minor.prototype10.Items;

import android.content.SharedPreferences;
import com.example.minor.prototype10.Models.ImportantItemName;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.RecoveryItemName;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * サブクラスで新しいメソッドを作った場合は必ずここにも書いてください。
 * アイテムの追加方法はrealmのcreateオブジェクトに名前を渡すだけ。
 * 自分の所持しているアイテムの名前をrealmに保存し、使う際にMakeDataに名前を渡して名前からアイテムのクラスを作成。
 * 使用後にrealmから名前を削除する。という流れ。
 * SuperItem型の変数にクラスを代入するためサブクラスのアイテムで作ったメソッドはスーパークラスにも書く必要がある。
 */
abstract public class SuperItem {
    protected Realm realm;
    protected PlayerInfo playerInfo;
    protected RealmResults<ImportantItemName> importantItemNames;
    protected RealmResults<RecoveryItemName> recoveryItemNames;
    protected ImportantItemName importantItemName;
    protected RecoveryItemName recoveryItemName;
    protected SharedPreferences sharedPreferences;
    protected SharedPreferences.Editor editor;

    abstract public String getName();
    abstract public String getInformation();

    //このメソッドを使う際はeditor.applyを忘れないようにする
    public void useMaterial(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        importantItemNames = realm.where(ImportantItemName.class).findAll();
        sharedPreferences = SuperOnClickMapButton.sharedPreferences;
        editor = sharedPreferences.edit();
    }

    public void useRecoveryItem(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        recoveryItemNames = realm.where(RecoveryItemName.class).findAll();
    }
}
