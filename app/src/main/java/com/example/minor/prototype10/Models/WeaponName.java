package com.example.minor.prototype10.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class WeaponName extends RealmObject{
    private String weaponName;

    private int weaponAtk;

    private int weaponLevel;

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
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
