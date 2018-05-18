package com.example.minor.prototype10.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ArmorName extends RealmObject{
    private String armorName;

    private int armorDf;

    private int armorLevel;

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
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
