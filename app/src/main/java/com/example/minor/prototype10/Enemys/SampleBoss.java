package com.example.minor.prototype10.Enemys;

/**
 * 最初にクラスのメンバとして敵のステータスを書いてください
 * 次にskillメソッドにスキルの中身を書き、setEnemyBehaviorメソッドに行動パターンを書いてください
 * 行動パターンを書くときはbeginTransactionとcommitTransactionで挟んでください
 * 後で要素を追加するときは先にSuperEnemyにメソッドを追加してください
 * 敵のbaseStatusは攻守の合計が240前後になるようにしてください
 */
public class SampleBoss extends SuperEnemy {
    private static final int baseHp = 120, sp = 10, baseAtk = 120, baseDf = 120, luk = 100;

    public int getHp() {
        return calculateHp(baseHp);
    }

    public int getSp() {
        return sp;
    }

    public int getAtk() {
        return calculateAtk(baseAtk);
    }

    public int getDf() {
        return calculateDf(baseDf);
    }

    public int getLuk() {
        return luk;
    }

    @Override
    protected void skill1(int[] allStatus) {
        beginTransaction(allStatus);
        newPlayerHp = playerHp - calculateDamage(atk);
        newBreakNum = breakNum - 4;
        commitTransaction();
    }

    @Override
    protected void skill2(int[] allStatus) {

    }

    @Override
    protected void skill3(int[] allStatus) {

    }

    @Override
    protected void skill4(int[] allStatus) {

    }

    @Override
    public int[] setEnemyBehavior(int[] tempAllStatus) {
        beginTransaction(tempAllStatus);
        skill1(allStatus);
        skill1(allStatus);
        skill1(allStatus);
        commitTransaction();
        return allStatus;
    }
}
