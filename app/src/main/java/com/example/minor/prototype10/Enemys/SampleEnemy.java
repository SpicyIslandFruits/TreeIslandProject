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
 * enemySkillsは後々マップに情報屋を追加するときにgetする
 */
public class SampleEnemy extends SuperEnemy {
    private static final int id = 1, baseHp = 120, sp = 10, baseAtk = 60, baseDf = 120, luk = 100;
    private static final String enemySkills = "通常攻撃、攻撃力10パーセントアップ、体力15パーセント回復";

    @Override
    public String getEnemySkills() {
        return null;
    }

    @Override
    public int getHp() {
        return calculateHp(baseHp);
    }

    @Override
    public int getSp() {
        return sp;
    }

    @Override
    public int getAtk() {
        return calculateAtk(baseAtk);
    }

    @Override
    public int getDf() {
        return calculateDf(baseDf);
    }

    @Override
    public int getLuk() {
        return luk;
    }

    @Override
    protected void skill1(int[] allStatus) {
        beginTransaction(allStatus);
        newEnemyAtk = (int)(enemyAtk*1.1);
        commitTransaction();
    }

    @Override
    protected void skill2(int[] allStatus) {
        beginTransaction(allStatus);
        if(calculateHp(baseHp) > (int)(enemyHp + calculateHp(baseHp)/8)){
            newEnemyHp = enemyHp + calculateHp(baseHp)/8;
        }
        commitTransaction();
    }

    @Override
    protected void skill3(int[] allStatus) {
        beginTransaction(allStatus);
        newPlayerHp = playerHp - calculateDamage(enemyAtk);
        newBreakNum = calculateBreakNum(breakNum);
        commitTransaction();
    }

    @Override
    protected void skill4(int[] allStatus) {
        beginTransaction(allStatus);
        newPlayerHp = playerHp - calculateDamage(enemyAtk);
        newBreakNum = calculateBreakNum(breakNum);
        commitTransaction();
    }

    @Override
    public int[] setEnemyBehavior(int[] tempAllStatus) {
        beginTransaction(tempAllStatus);
        skill1(allStatus);
        skill2(allStatus);
        skill3(allStatus);
        skill4(allStatus);
        commitTransaction();
        return allStatus;
    }
}
