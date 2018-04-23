package com.example.minor.prototype10.Weapons;

/**
 * 武器を追加したらMakeDataクラスでswitch文に処理を追加してください
 * 武器を取得するイベントを書いてください、取得する際にはPlayerInfoのweaponIdではなくRealmList<WeaponId>のほうにidを追加してください
 * playerAtkにはすでに武器装備時の攻撃力が代入されています
 * skillメソッドの中に処理を書いてください、spを消費させる処理を忘れないでください。
 * skillメソッドの処理はbeginTransactionとcommitTransactionで挟んでください
 * 後で要素を追加するときは先にSuperWeaponにメソッドを追加してください
 * skillInfoにはスキル名、スキルの効果、消費spを書いてください
 * ~~武器のステータスの決め方~~
 * X*(その武器を拾えるマップの基礎レベル)/100+5;
 * に150前後の値を代入して決めて下さい
 */
public class SampleWeapon extends SuperWeapon {
    private static final int id = 0;
    private static final String name = "SampleWeapon";
    private static final int atk = 150, skill1SpConsumption = 3, skill2SpConsumption = 5, skill3SpConsumption = 7;
    private static final String skill1Info = "普通の攻撃";
    private static final String skill2Info = "強い攻撃";
    private static final String skill3Info = "超強い攻撃";

    public int[] skill1(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - calculateDamage(calculateAtk(atk));
        commitTransaction(skill1SpConsumption);
        return newAllStatus;
    }

    public int[] skill2(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - calculateDamage(atk*1.5);
        commitTransaction(skill2SpConsumption);
        return newAllStatus;
    }

    public int[] skill3(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - calculateDamage(atk*2);
        commitTransaction(skill3SpConsumption);
        return newAllStatus;
    }

    public int getId() {
        return id;
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
}
