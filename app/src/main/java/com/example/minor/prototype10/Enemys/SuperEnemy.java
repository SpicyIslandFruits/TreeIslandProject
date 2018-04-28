package com.example.minor.prototype10.Enemys;

import com.example.minor.prototype10.Models.PlayerInfo;

import io.realm.Realm;

abstract public class SuperEnemy {
    protected int playerHp, playerMp, playerSp, playerAtk, playerDf, playerLuk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk, breakNum, playerMaxSp, playerLevel, weaponAtk, armorDf, enemyMaxSp;
    protected int newPlayerHp, newPlayerMp, newPlayerSp, newPlayerAtk, newPlayerDf, newPlayerLuk, newEnemyHp, newEnemySp, newEnemyAtk, newEnemyDf, newEnemyLuk, newBreakNum, newPlayerMaxSp, newPlayerLevel, newWeaponAtk, newArmorDf, newEnemyMaxSp;
    protected int[] allStatus, newAllStatus;
    private int damage;
    protected int hp, atk, df;
    protected Realm realm;
    protected PlayerInfo playerInfo;
    protected int skill1Priority, skill2Priority, skill3Priority, skill4Priority;
    protected int skill1SpConsumption, skill2SpConsumption, skill3SpConsumption, skill4SpConsumption;

    protected void setTempAllStatus(int[] tempAllStatus){
        allStatus = new int[17];
        newAllStatus = new int[17];
        newAllStatus = allStatus = tempAllStatus;
    }

    protected void beginTransaction(){
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

    protected void commitTransaction(int spConsumption){
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

    protected void poison(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setPoisonFlag(true);
        realm.commitTransaction();
        realm.close();
    }

    protected void bleeding(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setBleedingFlag(true);
        realm.commitTransaction();
        realm.close();
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
    protected int calculateDamage(int atk){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int enemyLevel = playerInfo.getBaseEnemyLevel()+playerInfo.getAdditionalEnemyLevel();
        damage = (int)(
                (
                        (( enemyLevel * 2 / 5 + 2) * (double)enemyAtk * (double)enemyAtk / (((double)playerDf+(double)armorDf)/2) /50 +2)
                                * ((double)85 + Math.random() * 15)
                ) / 100
        );
        realm.close();
        if (breakNum > 50 && breakNum < 100){
            damage = (int)((double)damage * 0.8);
        }else if(breakNum < 50){
            damage = (int)((double)damage * 1.2);
        }else if(breakNum >= 100){
            damage = (int)((double)damage*1.5);
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

    protected void chooseSkillWithinSp(int skill1Priority, int skill2Priority, int skill3Priority, int skill4Priority){
        boolean isSkill1Available = true, isSkill2Available = true, isSkill3Available = true, isSkill4Available = true;
        while (isSkill1Available || isSkill2Available || isSkill3Available || isSkill4Available) {
            while (isSkill1Available && isSkill2Available && isSkill3Available && isSkill4Available) {
                int prioritySum = skill1Priority + skill2Priority + skill3Priority + skill4Priority + 3;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill1Priority + skill2Priority + skill3Priority + 3 && tempPriority <= skill1Priority + skill2Priority + skill3Priority + skill4Priority + 3) {

                    if (skill4SpConsumption < newAllStatus[7]) {
                        skill4(allStatus);
                    } else {
                        isSkill4Available = false;
                    }

                } else if (tempPriority >= skill1Priority + skill2Priority + 2 && tempPriority <= skill1Priority + skill2Priority + skill3Priority + 2) {

                    if (skill3SpConsumption < newAllStatus[7]) {
                        skill3(allStatus);
                    } else {
                        isSkill3Available = false;
                    }

                } else if (tempPriority >= skill1Priority + 1 && tempPriority <= skill1Priority + skill2Priority + 1) {

                    if (skill2SpConsumption < newAllStatus[7]) {
                        skill2(allStatus);
                    } else {
                        isSkill2Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill1Priority) {

                    if (skill1SpConsumption < newAllStatus[7]) {
                        skill1(allStatus);
                    } else {
                        isSkill1Available = false;
                    }

                }
            }

            while (isSkill1Available && isSkill2Available && isSkill3Available && isSkill4Available == false) {
                int prioritySum = skill1Priority + skill2Priority + skill3Priority + 2;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill1Priority + skill2Priority + 2 && tempPriority <= skill1Priority + skill2Priority + skill3Priority + 2) {

                    if (skill3SpConsumption < newAllStatus[7]) {
                        skill3(allStatus);
                    } else {
                        isSkill3Available = false;
                    }

                } else if (tempPriority >= skill1Priority + 1 && tempPriority <= skill1Priority + skill2Priority + 1) {

                    if (skill2SpConsumption < newAllStatus[7]) {
                        skill2(allStatus);
                    } else {
                        isSkill2Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill1Priority) {

                    if (skill1SpConsumption < newAllStatus[7]) {
                        skill1(allStatus);
                    } else {
                        isSkill1Available = false;
                    }

                }
            }

            while (isSkill1Available && isSkill2Available && isSkill4Available && isSkill3Available == false) {
                int prioritySum = skill1Priority + skill2Priority + skill4Priority + 2;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill1Priority + skill2Priority + 2 && tempPriority <= skill1Priority + skill2Priority + skill4Priority + 2) {

                    if (skill4SpConsumption < newAllStatus[7]) {
                        skill4(allStatus);
                    } else {
                        isSkill4Available = false;
                    }

                } else if (tempPriority >= skill1Priority + 1 && tempPriority <= skill1Priority + skill2Priority + 1) {

                    if (skill2SpConsumption < newAllStatus[7]) {
                        skill2(allStatus);
                    } else {
                        isSkill2Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill1Priority) {

                    if (skill1SpConsumption < newAllStatus[7]) {
                        skill1(allStatus);
                    } else {
                        isSkill1Available = false;
                    }

                }
            }

            while (isSkill1Available && isSkill3Available && isSkill4Available && isSkill2Available == false) {
                int prioritySum = skill1Priority + skill3Priority + skill4Priority + 2;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill1Priority + skill3Priority + 2 && tempPriority <= skill1Priority + skill3Priority + skill4Priority + 2) {

                    if (skill4SpConsumption < newAllStatus[7]) {
                        skill4(allStatus);
                    } else {
                        isSkill4Available = false;
                    }

                } else if (tempPriority >= skill1Priority + 1 && tempPriority <= skill1Priority + skill3Priority + 1) {

                    if (skill3SpConsumption < newAllStatus[7]) {
                        skill3(allStatus);
                    } else {
                        isSkill3Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill1Priority) {

                    if (skill1SpConsumption < newAllStatus[7]) {
                        skill1(allStatus);
                    } else {
                        isSkill1Available = false;
                    }

                }
            }

            while (isSkill2Available && isSkill3Available && isSkill4Available && isSkill1Available == false) {
                int prioritySum = skill2Priority + skill3Priority + skill4Priority + 2;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill2Priority + skill3Priority + 2 && tempPriority <= skill2Priority + skill3Priority + skill4Priority + 2) {

                    if (skill4SpConsumption < newAllStatus[7]) {
                        skill4(allStatus);
                    } else {
                        isSkill4Available = false;
                    }

                } else if (tempPriority >= skill2Priority + 1 && tempPriority <= skill2Priority + skill3Priority + 1) {

                    if (skill3SpConsumption < newAllStatus[7]) {
                        skill3(allStatus);
                    } else {
                        isSkill3Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill2Priority) {

                    if (skill2SpConsumption < newAllStatus[7]) {
                        skill2(allStatus);
                    } else {
                        isSkill2Available = false;
                    }

                }
            }

            while (isSkill1Available && isSkill2Available && isSkill3Available == false && isSkill4Available == false){
                int prioritySum = skill1Priority + skill2Priority + 1;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill1Priority + 1 && tempPriority <= skill1Priority + skill2Priority + 1) {

                    if (skill2SpConsumption < newAllStatus[7]) {
                        skill2(allStatus);
                    } else {
                        isSkill2Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill1Priority) {

                    if (skill1SpConsumption < newAllStatus[7]) {
                        skill1(allStatus);
                    } else {
                        isSkill1Available = false;
                    }

                }
            }

            while (isSkill1Available && isSkill3Available && isSkill2Available == false && isSkill4Available == false){
                int prioritySum = skill1Priority + skill3Priority + 1;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill1Priority + 1 && tempPriority <= skill1Priority + skill3Priority + 1) {

                    if (skill3SpConsumption < newAllStatus[7]) {
                        skill3(allStatus);
                    } else {
                        isSkill3Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill1Priority) {

                    if (skill1SpConsumption < newAllStatus[7]) {
                        skill1(allStatus);
                    } else {
                        isSkill1Available = false;
                    }

                }
            }

            while (isSkill1Available && isSkill4Available && isSkill2Available == false && isSkill3Available == false){
                int prioritySum = skill1Priority + skill4Priority + 1;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill1Priority + 1 && tempPriority <= skill1Priority + skill4Priority + 1) {

                    if (skill4SpConsumption < newAllStatus[7]) {
                        skill4(allStatus);
                    } else {
                        isSkill4Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill1Priority) {

                    if (skill1SpConsumption < newAllStatus[7]) {
                        skill1(allStatus);
                    } else {
                        isSkill1Available = false;
                    }

                }
            }

            while (isSkill2Available && isSkill3Available && isSkill1Available == false && isSkill4Available == false){
                int prioritySum = skill2Priority + skill3Priority + 1;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill2Priority + 1 && tempPriority <= skill2Priority + skill3Priority + 1) {

                    if (skill3SpConsumption < newAllStatus[7]) {
                        skill3(allStatus);
                    } else {
                        isSkill3Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill2Priority) {

                    if (skill2SpConsumption < newAllStatus[7]) {
                        skill2(allStatus);
                    } else {
                        isSkill2Available = false;
                    }

                }
            }

            while (isSkill2Available && isSkill4Available && isSkill1Available == false && isSkill3Available == false){
                int prioritySum = skill2Priority + skill4Priority + 1;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill2Priority + 1 && tempPriority <= skill2Priority + skill4Priority + 1) {

                    if (skill4SpConsumption < newAllStatus[7]) {
                        skill4(allStatus);
                    } else {
                        isSkill4Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill2Priority) {

                    if (skill2SpConsumption < newAllStatus[7]) {
                        skill2(allStatus);
                    } else {
                        isSkill2Available = false;
                    }

                }
            }

            while (isSkill3Available && isSkill4Available && isSkill1Available == false && isSkill2Available == false){
                int prioritySum = skill3Priority + skill4Priority + 1;
                int tempPriority = (int) (prioritySum * Math.random());
                if (tempPriority >= skill3Priority + 1 && tempPriority <= skill3Priority + skill4Priority + 1) {

                    if (skill4SpConsumption < newAllStatus[7]) {
                        skill4(allStatus);
                    } else {
                        isSkill4Available = false;
                    }

                } else if (tempPriority >= 0 && tempPriority <= skill3Priority) {

                    if (skill3SpConsumption < newAllStatus[7]) {
                        skill3(allStatus);
                    } else {
                        isSkill3Available = false;
                    }
                }
            }

            while (isSkill1Available && isSkill2Available == false && isSkill3Available == false && isSkill4Available == false){
                if (skill1SpConsumption < newAllStatus[7]) {
                    skill1(allStatus);
                } else {
                    isSkill1Available = false;
                }
            }

            while (isSkill1Available == false && isSkill2Available && isSkill3Available == false && isSkill4Available == false){
                if (skill2SpConsumption < newAllStatus[7]) {
                    skill2(allStatus);
                } else {
                    isSkill2Available = false;
                }
            }

            while (isSkill1Available == false && isSkill2Available == false && isSkill3Available && isSkill4Available == false){
                if (skill3SpConsumption < newAllStatus[7]) {
                    skill3(allStatus);
                } else {
                    isSkill3Available = false;
                }
            }

            while (isSkill1Available == false && isSkill2Available == false && isSkill3Available == false && isSkill4Available){
                if (skill4SpConsumption < newAllStatus[7]) {
                    skill4(allStatus);
                } else {
                    isSkill4Available = false;
                }
            }
        }
    }
}
