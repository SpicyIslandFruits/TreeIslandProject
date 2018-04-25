package com.example.minor.prototype10.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ArmorId extends RealmObject{
    @PrimaryKey
    private int armorId;

    private int armorDf;

    private int armorLevel;

    public int getArmorId() {
        return armorId;
    }

    public void setArmorId(int armorId) {
        this.armorId = armorId;
    }

    public int getArmorDf() {
        return armorDf;
    }

    public void setArmorDf(int armorDf) {
        this.armorDf = armorDf;
    }

    public int getArmorLevel() {
        return armorLevel;
    }

    public void setArmorLevel(int armorLevel) {
        this.armorLevel = armorLevel;
    }
}
