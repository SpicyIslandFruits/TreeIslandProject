package com.example.minor.prototype10.Enemys;

import com.example.minor.prototype10.Models.PlayerInfo;

import io.realm.Realm;

abstract public class SuperEnemy {
    protected int playerHp, playerMp, playerSp, playerAtk, playerDf, playerLuk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk, breakNum, playerMaxSp, playerLevel, weaponAtk;
    protected int newPlayerHp, newPlayerMp, newPlayerSp, newPlayerAtk, newPlayerDf, newPlayerLuk, newEnemyHp, newEnemySp, newEnemyAtk, newEnemyDf, newEnemyLuk, newBreakNum, newPlayerMaxSp, newPlayerLevel, newWeaponAtk;
    protected int[] allStatus;
    private int damage;
    protected int hp, atk, df;
    private Realm realm;
    private PlayerInfo playerInfo;

    protected void beginTransaction(int[] allStatus){
        this.allStatus = new int[15];
        this.allStatus[0] = newPlayerHp = playerHp = allStatus[0];
        this.allStatus[1] = newPlayerMp = playerMp = allStatus[1];
        this.allStatus[2] = newPlayerSp = playerSp = allStatus[2];
        this.allStatus[3] = newPlayerAtk = playerAtk = allStatus[3];
        this.allStatus[4] = newPlayerDf = playerDf = allStatus[4];
        this.allStatus[5] = newPlayerLuk = playerLuk = allStatus[5];
        this.allStatus[6] = newEnemyHp = enemyHp = allStatus[6];
        this.allStatus[7] = newEnemySp = enemySp = allStatus[7];
        this.allStatus[8] = newEnemyAtk = enemyAtk = allStatus[8];
        this.allStatus[9] = newEnemyDf = enemyDf = allStatus[9];
        this.allStatus[10] = newEnemyLuk = enemyLuk = allStatus[10];
        this.allStatus[11] = newBreakNum = breakNum = allStatus[11];
        this.allStatus[12] = newPlayerMaxSp = playerMaxSp = allStatus[12];
        this.allStatus[13] = newPlayerLevel = playerLevel = allStatus[13];
        this.allStatus[14] = newWeaponAtk = weaponAtk = allStatus[14];
    }

    protected void commitTransaction(){
        allStatus[0] = newPlayerHp;
        allStatus[1] = newPlayerMp;
        allStatus[2] = newPlayerSp;
        allStatus[3] = newPlayerAtk;
        allStatus[4] = newPlayerDf;
        allStatus[5] = newPlayerLuk;
        allStatus[6] = newEnemyHp;
        allStatus[7] = newEnemySp;
        allStatus[8] = newEnemyAtk;
        allStatus[9] = newEnemyDf;
        allStatus[10] = newEnemyLuk;
        allStatus[11] = newBreakNum;
        allStatus[12] = newPlayerMaxSp;
        allStatus[13] = newPlayerLevel;
        allStatus[14] = newWeaponAtk;
    }

    abstract public int getHp();
    abstract public int getSp();
    abstract public int getAtk();
    abstract public int getDf();
    abstract public int getLuk();
    abstract protected void skill1(int[] tempAllStatus);
    abstract protected void skill2(int[] tempAllStatus);
    abstract protected void skill3(int[] tempAllStatus);
    abstract protected void skill4(int[] tempAllStatus);
    abstract public int[] setEnemyBehavior(int[] tempAllStatus);
    //式中のatkはcalculateAtkメソッドを実行したときに代入されたもの
    protected int calculateDamage(int atk){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int enemyLevel = playerInfo.getBaseEnemyLevel()+playerInfo.getAdditionalEnemyLevel();
        damage = (int)(
                (
                        (( enemyLevel * 2 / 5 + 2) * (double)enemyAtk * (double)enemyAtk / (double)playerDf /50 +2)
                                * ((double)85 + Math.random() * 15)
                ) / 100
        );
        realm.close();
        if (breakNum > 50){
            damage = (int)((double)damage * 0.8);
        }else if(breakNum < 50){
            damage = (int)((double)damage * 1.2);
        }
        return damage;
    }

    //hp = の行の最後の数字はmakePlayerStatusFromLevelの数字に合わせる
    protected int calculateHp(int baseHp){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int enemyLevel = playerInfo.getBaseEnemyLevel()+playerInfo.getAdditionalEnemyLevel();
        hp = (baseHp*(enemyLevel)/100 + enemyLevel + 10) * 4;
        realm.close();
        return hp;
    }

    protected int calculateAtk(int baseAtk){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int enemyLevel = playerInfo.getBaseEnemyLevel()+playerInfo.getAdditionalEnemyLevel();
        atk = baseAtk*(enemyLevel)/100 + 5;
        realm.close();
        return atk;
    }

    protected int calculateDf(int baseDf){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int enemyLevel = playerInfo.getBaseEnemyLevel()+playerInfo.getAdditionalEnemyLevel();
        df = baseDf*(enemyLevel)/100 + 5;
        realm.close();
        return df;
    }

    protected int calculateBreakNum(int breakNum){
        int num = breakNum;
        if(num > 50){
            num = num - 8;
            if(num <= 50){
                num = 20;
            }
        }else if(breakNum <= 50){
            num = num - 4;
        }

        if(num < 0){
            num = 0;
        }
        return num;
    }
}
