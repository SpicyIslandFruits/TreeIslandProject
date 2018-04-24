package com.example.minor.prototype10.Weapons;

import com.example.minor.prototype10.Models.PlayerInfo;

import io.realm.Realm;

abstract public class SuperWeapon {
    protected int playerHp, playerMp, playerSp, playerAtk, playerDf, playerLuk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk, breakNum, playerMaxSp, playerLevel, weaponAtk;
    protected int newPlayerHp, newPlayerMp, newPlayerSp, newPlayerAtk, newPlayerDf, newPlayerLuk, newEnemyHp, newEnemySp, newEnemyAtk, newEnemyDf, newEnemyLuk, newBreakNum ,newPlayerMaxSp, newPlayerLevel, newWeaponAtk;
    protected int[] newAllStatus;
    private int damage;
    private Realm realm;
    private PlayerInfo playerInfo;

    public void beginTransaction(int[] tempAllStatus){
        newAllStatus = new int[15];
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
        newBreakNum = breakNum = tempAllStatus[11];
        newPlayerMaxSp = playerMaxSp = tempAllStatus[12];
        newPlayerLevel = playerLevel = tempAllStatus[13];
        newWeaponAtk = weaponAtk = tempAllStatus[14];
    }

    protected void commitTransaction(int spConsumption){
        newAllStatus[0] = newPlayerHp;
        newAllStatus[1] = newPlayerMp;
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
    }

    abstract public int[] skill1(int[] tempAllStatus);
    abstract public int[] skill2(int[] tempAllStatus);
    abstract public int[] skill3(int[] tempAllStatus);
    abstract public int getId();
    abstract public String getName();
    abstract public int getAtk();
    abstract public String getSkill1Info();
    abstract public String getSkill2Info();
    abstract public String getSkill3Info();
    abstract public String getSkill1Name();
    abstract public String getSkill2Name();
    abstract public String getSkill3Name();

    protected int calculateDamage(){
        damage = (int)(
                (
                (( (double)playerLevel * 2 / 5 + 2) * weaponAtk * (double)playerAtk / (double)enemyDf /50 +2)
                * ((double)85 + Math.random() * 15)
                ) / 100
        );
        if (breakNum > 50){
            damage = (int) ((double)damage * 1.2);
        }else if (breakNum < 50){
            damage = (int)((double)damage * 0.8);
        }
        return damage;
    }

    //通常攻撃の威力はゲームバランスによって変更してください
    public int[] skill0(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - calculateDamage();
        commitTransaction(playerMaxSp/3);
        return newAllStatus;
    }
}
