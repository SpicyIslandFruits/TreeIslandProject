package com.example.minor.prototype10.PlayerSkill;

import com.example.minor.prototype10.Models.PlayerInfo;

import io.realm.Realm;

abstract public class SuperSkill {
    protected int playerHp, playerMp, playerSp, playerAtk, playerDf, playerLuk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk, breakNum, playerMaxSp, playerLevel, weaponAtk, armorDf, enemyMaxSp;
    protected int newPlayerHp, newPlayerMp, newPlayerSp, newPlayerAtk, newPlayerDf, newPlayerLuk, newEnemyHp, newEnemySp, newEnemyAtk, newEnemyDf, newEnemyLuk, newBreakNum, newPlayerMaxSp, newPlayerLevel, newWeaponAtk, newArmorDf, newEnemyMaxSp;
    protected int[] newAllStatus;
    protected Realm realm;
    protected PlayerInfo playerInfo;

    protected void beginTransaction(int[] tempAllStatus){
        newAllStatus = new int[17];
        newPlayerHp = playerHp = tempAllStatus[0];
        newPlayerMp = playerMp = tempAllStatus[1];
        newPlayerSp = playerSp = tempAllStatus[2];
        newPlayerAtk = playerAtk = tempAllStatus[3];
        newPlayerDf = playerDf = tempAllStatus[4];
        newPlayerLuk = playerLuk = tempAllStatus[5];
        newEnemyHp = enemyHp = tempAllStatus[6];
        newEnemySp = enemySp = tempAllStatus[7];
        newEnemyAtk = enemyAtk = tempAllStatus[8];
        newEnemyDf = enemyDf = tempAllStatus[9];
        newEnemyLuk = enemyLuk = tempAllStatus[10];
        newBreakNum =  breakNum = tempAllStatus[11];
        newPlayerMaxSp = playerMaxSp = tempAllStatus[12];
        newPlayerLevel = playerLevel = tempAllStatus[13];
        newWeaponAtk = weaponAtk = tempAllStatus[14];
        newArmorDf = armorDf = tempAllStatus[15];
        newEnemyMaxSp = enemyMaxSp = tempAllStatus[16];
    }

    protected void commitTransaction(int spConsumption, int mpConsumption){
        newAllStatus[0] = newPlayerHp;
        newAllStatus[1] = newPlayerMp - mpConsumption;
        newAllStatus[2] = newPlayerSp - spConsumption;
        newAllStatus[3] = newPlayerAtk;
        newAllStatus[4] = newPlayerDf;
        newAllStatus[5] = newPlayerLuk;
        newAllStatus[6] = newEnemyHp;
        newAllStatus[7] = newEnemySp;
        newAllStatus[8] = newEnemyAtk;
        newAllStatus[9] = newEnemyDf;
        newAllStatus[10] = newEnemyLuk;
        newAllStatus[11] = newBreakNum;
        newAllStatus[12] = newPlayerMaxSp;
        newAllStatus[13] = newPlayerLevel;
        newAllStatus[14] = newWeaponAtk;
        newAllStatus[15] = newArmorDf;
        newAllStatus[16] = newEnemyMaxSp;
    }

    protected void setEnemyPoison(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setEnemyPoisonFlag(true);
        realm.commitTransaction();
        realm.close();
    }

    protected void setPlayerAutoHealing(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setPlayerAutoHealingFlag(true);
        realm.commitTransaction();
        realm.close();
    }

    protected void setPlayerAutoAbsorbing(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setPlayerAutoAbsorbingFlag(true);
        realm.commitTransaction();
        realm.close();
    }

    abstract public int[] skill(int[] tempAllStatus);
    abstract public int getId();
    abstract public String getName();
    abstract public String getSkillInfo();
    abstract public String getSkillName();

}
