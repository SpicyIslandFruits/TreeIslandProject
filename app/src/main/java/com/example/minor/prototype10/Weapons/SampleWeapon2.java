package com.example.minor .prototype10.Weapons;

public class SampleWeapon2 extends SuperWeapon {
    private static final String name = "SampleWeapon2";
    private static final String skill1Name = "SampleSkill1";
    private static final String skill2Name = "SampleSkill2";
    private static final String skill3Name = "SampleSkill3";
    private static final int atk = 150, skill1SpConsumption = 70, skill2SpConsumption = 280, skill3SpConsumption = 30;
    private static final String skill1Info = "spを増やします";
    private static final String skill2Info = "一撃必殺";
    private static final String skill3Info = "普通の攻撃";

    public int[] skill1(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newPlayerMaxSp = playerMaxSp + 20;
        commitTransaction(skill1SpConsumption);
        return newAllStatus;
    }

    public int[] skill2(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = 0;
        commitTransaction(skill2SpConsumption);
        return newAllStatus;
    }

    public int[] skill3(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - calculateDamage();
        commitTransaction(skill3SpConsumption);
        return newAllStatus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAtk() {
        return atk;
    }

    @Override
    public String getSkill1Info() {
        return skill1Info;
    }

    @Override
    public String getSkill2Info() {
        return skill2Info;
    }

    @Override
    public String getSkill3Info() {
        return skill3Info;
    }

    @Override
    public String getSkill1Name() {
        return skill1Name;
    }

    @Override
    public String getSkill2Name() {
        return skill2Name;
    }

    @Override
    public String getSkill3Name() {
        return skill3Name;
    }
}
