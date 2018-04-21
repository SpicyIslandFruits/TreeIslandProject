package com.example.minor .prototype10.Weapons;

public class SampleWeapon2 extends SuperWeapon {
    private static final int id = 1;
    private static final String name = "SampleWeapon2";
    private static final int atk = 10;
    private static final String skill1Info = "釘パンチ、攻撃力の1.5倍の威力";
    private static final String skill2Info = "10万ボルト、攻撃力の10万倍の威力";
    private static final String skill3Info = "ハイドロポンプ、攻撃力の2倍の威力";

    public int[] skill1(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        commitTransaction();
        return newAllStatus;
    }

    public int[] skill2(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
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
