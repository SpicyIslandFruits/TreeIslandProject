package com.example.minor.prototype10.Enemys;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.R;

import io.realm.Realm;

abstract public class SuperEnemy {
    protected int playerHp, playerMp, playerSp, playerAtk, playerDf, playerLuk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk, breakNum, playerMaxSp, playerLevel, weaponAtk, armorDf, enemyMaxSp;
    protected int newPlayerHp, newPlayerMp, newPlayerSp, newPlayerAtk, newPlayerDf, newPlayerLuk, newEnemyHp, newEnemySp, newEnemyAtk, newEnemyDf, newEnemyLuk, newBreakNum, newPlayerMaxSp, newPlayerLevel, newWeaponAtk, newArmorDf, newEnemyMaxSp;
    protected int[] allStatus, newAllStatus;
    private int damage;
    protected int hp, atk, df;
    protected Realm realm;
    protected PlayerInfo playerInfo;
    protected AppCompatActivity mBattleActivity;

    protected void setTempAllStatus(int[] tempAllStatus) {
        allStatus = new int[17];
        newAllStatus = new int[17];
        newAllStatus = allStatus = tempAllStatus;
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
    }

    protected void beginTransaction() {
        allStatus = newAllStatus;
        newPlayerHp = playerHp = allStatus[0];
        newPlayerMp = playerMp = allStatus[1];
        newPlayerSp = playerSp = allStatus[2];
        newPlayerAtk = playerAtk = allStatus[3];
        newPlayerDf = playerDf = allStatus[4];
        newPlayerLuk = playerLuk = allStatus[5];
        newEnemyHp = enemyHp = allStatus[6];
        newEnemySp = enemySp = allStatus[7];
        newEnemyAtk = enemyAtk = allStatus[8];
        newEnemyDf = enemyDf = allStatus[9];
        newEnemyLuk = enemyLuk = allStatus[10];
        newBreakNum = breakNum = allStatus[11];
        newPlayerMaxSp = playerMaxSp = allStatus[12];
        newPlayerLevel = playerLevel = allStatus[13];
        newWeaponAtk = weaponAtk = allStatus[14];
        newArmorDf = armorDf = allStatus[15];
        newEnemyMaxSp = enemyMaxSp = allStatus[16];
    }

    protected void commitTransaction(int spConsumption) {
        newAllStatus[0] = newPlayerHp;
        newAllStatus[1] = newPlayerMp;
        newAllStatus[2] = newPlayerSp;
        newAllStatus[3] = newPlayerAtk;
        newAllStatus[4] = newPlayerDf;
        newAllStatus[5] = newPlayerLuk;
        newAllStatus[6] = newEnemyHp;
        newAllStatus[7] = newEnemySp - spConsumption;
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

    protected void poison() {
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setPoisonFlag(true);
        realm.commitTransaction();
    }

    protected void bleeding() {
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setBleedingFlag(true);
        realm.commitTransaction();
    }

    abstract public int getHp();

    abstract public int getSp();

    abstract public int getAtk();

    abstract public int getDf();

    abstract public int getLuk();

    abstract public String getEnemySkills();

    abstract protected void skill1(int[] allStatus);

    abstract protected void skill2(int[] allStatus);

    abstract protected void skill3(int[] allStatus);

    abstract protected void skill4(int[] allStatus);

    abstract public int[] setEnemyBehavior(int[] tempAllStatus);

    //防具の実装方法
    //playerDfの所を((playerDf + weaponDf)/2)にする
    protected int calculateDamage() {
        int enemyLevel = playerInfo.getBaseEnemyLevel() + playerInfo.getAdditionalEnemyLevel();
        damage = (int) (
                (
                        ((enemyLevel * 2 / 5 + 2) * (double) enemyAtk * (double) enemyAtk / (((double) playerDf + (double) armorDf) / 2) / 50 + 2)
                                * ((double) 85 + Math.random() * 15)
                ) / 100
        );
        if (breakNum > 50 && breakNum < 100) {
            damage = (int) ((double) damage * 0.8);
        } else if (breakNum < 50) {
            damage = (int) ((double) damage * 1.2);
        } else if (breakNum >= 100) {
            damage = (int) ((double) damage * 1.5);
        }
        return damage;
    }

    //hp = の行の最後の数字はmakePlayerStatusFromLevelの数字に合わせる
    protected int calculateHp(int baseHp) {
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int enemyLevel = playerInfo.getBaseEnemyLevel() + playerInfo.getAdditionalEnemyLevel();
        hp = (baseHp * (enemyLevel) / 100 + enemyLevel + 10) * 4;
        realm.close();
        return hp;
    }

    protected int calculateAtk(int baseAtk) {
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int enemyLevel = playerInfo.getBaseEnemyLevel() + playerInfo.getAdditionalEnemyLevel();
        atk = baseAtk * (enemyLevel) / 100 + 5;
        realm.close();
        return atk;
    }

    protected int calculateDf(int baseDf) {
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int enemyLevel = playerInfo.getBaseEnemyLevel() + playerInfo.getAdditionalEnemyLevel();
        df = baseDf * (enemyLevel) / 100 + 5;
        realm.close();
        return df;
    }

    protected int calculateBreakNum(int breakNum) {
        int num = breakNum;
        if (num > 50) {
            num = num - 8;
            if (num <= 50) {
                num = 20;
            }
        } else if (breakNum <= 50) {
            num = num - 4;
        }

        if (num < 0) {
            num = 0;
        }
        return num;
    }
    protected void chooseSkills(int n){
        switch(n){
            case 0:
                skill1(allStatus);
                break;
            case 1:
                skill2(allStatus);
                break;
            case 2:
                skill3(allStatus);
                break;
            case 4:
                skill4(allStatus);
                break;
        }
    }

    protected void chooseSkillWithinSp(int skill1Priority, int skill1SpConsumption,int skill2Priority, int skill2SpConsumption, int skill3Priority, int skill3SpConsumption,  int skill4Priority, int skill4SpConsumption){
        boolean[] isSkillAvailable = {true,true,true,true};
        int[] skillPriority={skill1Priority,skill2Priority,skill3Priority,skill4Priority};
        int[] skillSpConsumption={skill1SpConsumption,skill2SpConsumption,skill3SpConsumption,skill4SpConsumption};

        for (int AvailableSkills=4;AvailableSkills>=1;){
            int prioritySum = 0;
            for(int i=0;i<4;++i){
                if(isSkillAvailable[i]){
                    prioritySum+=(skillPriority[i]+1);
                }
            }
            prioritySum--;
            prioritySum=(int) (prioritySum * Math.random());
            for(int i=0;i<4;++i){
                if(isSkillAvailable[i]){
                    if (prioritySum>= 0 && prioritySum <= skillPriority[i]){
                        if (skillSpConsumption[i] < newAllStatus[7]) {
                            chooseSkills(i);
                        } else {
                            isSkillAvailable[i] = false;
                            AvailableSkills--;
                        }
                        break;
                    }
                    prioritySum-=(skillPriority[i]+1);
                }
            }
        }
    }
}