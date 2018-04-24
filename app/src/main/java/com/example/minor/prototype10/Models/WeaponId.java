package com.example.minor.prototype10.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class WeaponId extends RealmObject{
    @PrimaryKey
    private int weaponId;

    private int weaponAtk;

    private int weaponLevel;

    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public int getWeaponAtk() {
        return weaponAtk;
    }

    public void setWeaponAtk(int weaponAtk) {
        this.weaponAtk = weaponAtk;
    }

    public int getWeaponLevel() {
        return weaponLevel;
    }

    public void setWeaponLevel(int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }
}
