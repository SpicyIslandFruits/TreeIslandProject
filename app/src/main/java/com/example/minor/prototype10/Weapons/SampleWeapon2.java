package com.example.minor .prototype10.Weapons;


public class SampleWeapon2 extends SuperWeapon {
    private static final int id = 1;
    private static final String name = "SampleWeapon2";
    private static final int atk = 10;
    private static final String skill1Info = "spを増やします";
    private static final String skill2Info = "一撃必殺";
    private static final String skill3Info = "";

    public int[] skill1(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newPlayerMaxSp = playerMaxSp + 2;
        newPlayerSp = playerSp -7;
        commitTransaction();
        return newAllStatus;
    }

    public int[] skill2(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newPlayerSp = playerSp - 20;
        newEnemyHp = 0;
        commitTransaction();
        return newAllStatus;
    }

    public int[] skill3(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        commitTransaction();
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
}
