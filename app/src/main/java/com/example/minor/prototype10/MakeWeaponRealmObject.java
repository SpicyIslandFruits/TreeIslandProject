package com.example.minor.prototype10;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponName;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.Realm;

/**
 * このクラスでは新しい武器を拾った際にRealmListにその武器の情報を保存します
 */
public class MakeWeaponRealmObject {
    private MakeData makeData;
    private SuperWeapon superWeapon;
    private int newWeaponAtk;
    private PlayerInfo playerInfo;
    private Realm realm;
    private int weaponLevel;
    private WeaponName weaponName;

    public void createNewWeapon(String weaponName){
        realm = Realm.getDefaultInstance();
        makeData = new MakeData();
        superWeapon = makeData.makeWeaponFromName(weaponName);
        newWeaponAtk = calculateAtk(superWeapon.getAtk());
        realm.beginTransaction();
        this.weaponName = realm.createObject(WeaponName.class);
        this.weaponName.setWeaponName(superWeapon.getName());
        this.weaponName.setWeaponAtk(newWeaponAtk);
        this.weaponName.setWeaponLevel(weaponLevel);
        playerInfo.setWeaponName(weaponName);
        playerInfo.getEquippedWeapons().add(this.weaponName);
        realm.commitTransaction();
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
