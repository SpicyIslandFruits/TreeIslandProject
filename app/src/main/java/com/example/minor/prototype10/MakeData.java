package com.example.minor.prototype10;

import com.example.minor.prototype10.Armors.SampleArmor;
import com.example.minor.prototype10.Armors.SampleArmor2;
import com.example.minor.prototype10.Armors.SuperArmor;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.Weapons.SampleWeapon;
import com.example.minor.prototype10.Weapons.SampleWeapon2;
import com.example.minor.prototype10.Weapons.SuperWeapon;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBossRoomButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickDungeonButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickInnButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickTownButton;

import io.realm.Realm;

/**
 * パッケージにクラスを追加したらここにswitch文を追加する
 * どのメソッドもreturn分を含むのでvoidを変える
 * 武器防具は重複不可、同一武器を拾った場合は捨てたり換金したり
 * アイテムもPrimaryKeyが名前になっているのでこのままだと重複不可あとで何とかする
 */

public class MakeData {
    private static final int playerBaseStatus = 120;
    private Realm realm;
    private PlayerInfo playerInfo;

    //マップを追加したときはここに書く
    public SuperOnClickMapButton makeMapFromPosition(int position){
        SuperOnClickMapButton onClickMapButton = new OnClickInnButton();
        switch (position){
            case 0:
                onClickMapButton = new OnClickInnButton();
                break;
            case 1:
                onClickMapButton = new OnClickTownButton();
                break;
            case 2:
                onClickMapButton = new OnClickDungeonButton();
                break;
            case 3:
                onClickMapButton = new OnClickBossRoomButton();
                break;
        }
        return onClickMapButton;
    }

    //レベルを受け取ってステータスを生成しRealmに渡す
    //lukとspとmpはレベルによって変化はしない
    //lukに関しては装飾品やスキル、フィールドバフによって変化するが能力値は一定でlukの数値がそのままクリティカル率になる。また、ごみをあさるなどでアイテムを取得できる確率もluk
    //mpとspはゲージでのみ表示し、数値は出さない
    //setMaxHpの最後の2つの数字はそれぞれ主人公が同じレベルの敵を平均何回の平均的な攻撃で倒せるか(此処を変更した場合superEnemyの数字も変更)、hpがマックスの状態から何体の敵を倒せるかを表す
    public void makePlayerStatusFromLevel(int level){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setMaxHP((playerBaseStatus*level/100+level+10) * 4 * 4);
        playerInfo.setDF(playerBaseStatus*level/100+5);
        playerInfo.setATK(playerBaseStatus*level/100+5);
        realm.commitTransaction();
        realm.close();
    }

    //プレイヤースキルを追加した場合はここに書く
    public void makePlayerSkillFromId(int id){}

    //idを受け取って敵クラスのインスタンスを返しますmakeWeaponFromIdを参照して書いてください
    public void makeEnemyFromId(int id){

    }

    //武器を追加した場合はここに書く
    public SuperWeapon makeWeaponFromId(int id){
        SuperWeapon weapon = new SampleWeapon();
        switch (id){
            case 0:
                weapon = new SampleWeapon();
                break;
            case 1:
                weapon = new SampleWeapon2();
                break;
        }
        return weapon;
    }

    //防具を追加した場合はここに書く
    public SuperArmor makeArmorFromId(int id){
        SuperArmor armor = new SampleArmor();
        switch (id){
            case 0:
                armor = new SampleArmor();
                break;
            case 1:
                armor = new SampleArmor2();
                break;
        }
        return armor;
    }

    //アイテムを追加した場合はここに書く
    public void makeItemFromId(int id){

    }
}
