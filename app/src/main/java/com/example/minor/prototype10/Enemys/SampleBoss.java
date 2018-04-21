package com.example.minor.prototype10.Enemys;

/**
 * 最初にクラスのメンバとして敵のステータスを書いてください
 * 次にskillメソッドにスキルの中身を書き、setEnemyBehaviorメソッドに行動パターンを書いてください
 * 行動パターンを書くときはbeginTransactionとcommitTransactionで挟んでください
 * 後で要素を追加するときは先にSuperEnemyにメソッドを追加してください
 */
public class SampleBoss extends SuperEnemy {
    private static final int hp = 500, sp = 10, atk = 10, df = 100, luk = 100;

    public int getHp() {
        return hp;
    }

    public int getSp() {
        return sp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDf() {
        return df;
    }

    public int getLuk() {
        return luk;
    }

    @Override
    protected void skill1(int[] tempAllStatus) {
        newPlayerHp = playerHp - enemyAtk;
        newBreakNum = breakNum - 12;
    }

    @Override
    protected void skill2(int[] tempAllStatus) {

    }

    @Override
    protected void skill3(int[] tempAllStatus) {

    }

    @Override
    protected void skill4(int[] tempAllStatus) {

    }

    @Override
    public int[] setEnemyBehavior(int[] tempAllStatus) {
        beginTransaction(tempAllStatus);
        skill1(tempAllStatus);
        commitTransaction();
        return newAllStatus;
    }
}
