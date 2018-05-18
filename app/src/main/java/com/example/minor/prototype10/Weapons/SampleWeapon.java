package com.example.minor.prototype10.Weapons;

/**
 * 武器を追加したらMakeDataクラスでswitch文に処理を追加してください
 * 武器を取得するイベントを書いてください、取得する際にはPlayerInfoのweaponIdではなくRealmList<WeaponName>のほうにidを追加してください
 * playerAtkにはすでに武器装備時の攻撃力が代入されています
 * skillメソッドの中に処理を書いてください、spを消費させる処理を忘れないでください。
 * skillメソッドの処理はbeginTransactionとcommitTransactionで挟んでください
 * 後で要素を追加するときは先にSuperWeaponにメソッドを追加してください
 * skillInfoにはスキル名、スキルの効果、消費spを書いてください
 * 武器のatkは150前後
 */
public class SampleWeapon extends SuperWeapon {
    private static final String name = "SampleWeapon";
    private static final String skill1Name = "SampleSkill1";
    private static final String skill2Name = "SampleSkill2";
    private static final String skill3Name = "SampleSkill3";
    private static final int atk = 150, skill1SpConsumption = 30, skill2SpConsumption = 180, skill3SpConsumption = 30;
    private static final String skill1Info = "普通の攻撃";
    private static final String skill2Info = "敵のSpを減らします";
    private static final String skill3Info = "ブレイクゲージを多く削る攻撃";

    public int[] skill1(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - calculateDamage();
        commitTransaction(skill1SpConsumption);
        return newAllStatus;
    }

    public int[] skill2(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyMaxSp = enemyMaxSp - 10;
        commitTransaction(skill2SpConsumption);
        return newAllStatus;
    }

    public int[] skill3(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - (int)(calculateDamage()*0.5);
        newBreakNum = breakNum + 4;
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

    public String getSkill1Info() {
        return skill1Info;
    }

    public String getSkill2Info() {
        return skill2Info;
    }

    public String getSkill3Info() {
        return skill3Info;
    }

    public String getSkill1Name() {
        return skill1Name;
    }

    public String getSkill2Name() {
        return skill2Name;
    }

    public String getSkill3Name() {
        return skill3Name;
    }
}
