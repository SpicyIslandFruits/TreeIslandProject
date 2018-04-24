package com.example.minor.prototype10;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.Realm;

public class MakeWeaponRealmObject {
    private MakeData makeData;
    private SuperWeapon superWeapon;
    private int newWeaponAtk;
    private PlayerInfo playerInfo;
    private Realm realm;
    private int weaponLevel;
    private WeaponId weaponId;

    //現在は問答無用で強い方の武器を作成しているが、実際は確認ダイヤログを出す
    public void createNewWeapon(int id){
        realm = Realm.getDefaultInstance();
        makeData = new MakeData();
        superWeapon = makeData.makeWeaponFromId(id);
        newWeaponAtk = calculateAtk(superWeapon.getAtk());
        try{
            realm.beginTransaction();
            weaponId = realm.createObject(WeaponId.class, new Integer(id));
            weaponId.setWeaponAtk(newWeaponAtk);
            weaponId.setWeaponLevel(weaponLevel);
            playerInfo.getWeaponIds().add(weaponId);
            realm.commitTransaction();
        }catch (Exception e){
            realm.cancelTransaction();
            weaponId = realm.where(WeaponId.class).findFirst();
            if(weaponId.getWeaponAtk() <= newWeaponAtk){
                realm.beginTransaction();
                weaponId = realm.createObject(WeaponId.class, new Integer(id));
                weaponId.setWeaponAtk(newWeaponAtk);
                weaponId.setWeaponLevel(weaponLevel);
                playerInfo.getWeaponIds().add(weaponId);
                realm.commitTransaction();
            }
        }
        realm.close();
    }

    //かける10となっているところは後で修正する可能性あり、これは特定の階層と次の階層のbaseEnemyLevelの差である
    public int calculateAtk(int atk){
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        weaponLevel = (playerInfo.getBaseEnemyLevel()) + (int)(Math.random()*10);
        atk = atk*(weaponLevel)/100 + 5;
        return atk;
    }
}
