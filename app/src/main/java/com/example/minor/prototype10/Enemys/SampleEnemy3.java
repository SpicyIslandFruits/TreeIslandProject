package com.example.minor.prototype10.Enemys;

/**
 * 最初にクラスのメンバとして敵のステータスを書いてください
 * 次にskillメソッドにスキルの中身を書き、setEnemyBehaviorメソッドに行動パターンを書いてください
 * 行動パターンを書くときはbeginTransactionとcommitTransactionで挟んでください
 * 後で要素を追加するときは先にSuperEnemyにメソッドを追加してください
 * 敵のbaseStatusは攻守HPの合計が360前後になるようにしてください
 * hp,atk,dfについては絶対にcalculateメソッドを使ってからreturnしてください
 * 必ずidも書いておいてください後からどのidがどの敵だったかを確認できます
 * ダメージの入るスキルの実装の際はnewBreakNum = calculateBreakNum(breakNum)を必ず書く
 */
public class SampleEnemy3 extends SuperEnemy {
    private static final int id = 0, baseHp = 120, sp = 100, baseAtk = 120, baseDf = 120, luk = 10;
    private static final String enemySkills = "通常攻撃のみ行います";

    //HpとAtkとDfについては必ずcalculateメソッドを使ってからreturnしてください
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
    public String getEnemySkills() {
        return enemySkills;
    }

    @Override
    protected void skill1(int[] allStatus) {
        beginTransaction();
        newPlayerHp = playerHp - calculateDamage();
        newBreakNum = calculateBreakNum(breakNum);
        commitTransaction(30);
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
        setTempAllStatus(tempAllStatus);
        beginTransaction();
        chooseSkillWithinSp(100, 30, 0, 100, 0, 100, 0, 100);
        return allStatus;
    }
}
