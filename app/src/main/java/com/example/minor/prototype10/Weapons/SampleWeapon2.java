package com.example.minor .prototype10.Weapons;


public class SampleWeapon2 extends SuperWeapon {
    private static final int id = 1;
    private static final String name = "SampleWeapon2";
    private static final int atk = 10;
    private static final String skill1Name = "SampleSkill1";
    private static final String skill2Name = "SampleSkill2";
    private static final String skill3Name = "SampleSkill3";
    private static final String skill1Info = "spを増やします";
    private static final String skill2Info = "一撃必殺";
    private static final String skill3Info = "ブレイクゲージを多く削る攻撃";

    public int[] skill1(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newPlayerMaxSp = playerMaxSp + 2;
        commitTransaction(7);
        return newAllStatus;
    }

    public int[] skill2(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = 0;
        commitTransaction(20);
        return newAllStatus;
    }

    public int[] skill3(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - playerAtk;
        newBreakNum = breakNum + 45;
        commitTransaction(5);
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
    public int getId() {
        return id;
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
