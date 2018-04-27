package com.example.minor.prototype10.Enemys;

/**
 * 最初にクラスのメンバとして敵のステータスを書いてください
 * 次にskillメソッドにスキルの中身を書き、setEnemyBehaviorメソッドに行動パターンを書いてください
 * 行動パターンを書くときはbeginTransactionとcommitTransactionで挟んでください
 * 後で要素を追加するときは先にSuperEnemyにメソッドを追加してください
 * 敵の基礎ステータスは攻守HPすべて120ですSpの基準値は100です
 * hp,atk,dfについては絶対にcalculateメソッドを使ってからreturnしてください
 * 必ずidも書いておいてください後からどのidがどの敵だったかを確認できます
 * ダメージの入るスキルの実装の際はnewBreakNum = calculateBreakNum(breakNum)を必ず書く
 * enemySkillsは後々マップに情報屋を追加するときにgetする
 * 敵のスキルは
 */
public class SampleEnemy extends SuperEnemy {
    private static final int id = 1, baseHp = 120, sp = 100, baseAtk = 120, baseDf = 120, luk = 100;
    private static final String enemySkills = "通常攻撃、攻撃力10パーセントアップ、体力15パーセント回復";
    private static final int skill1SpConsumption = 50, skill2SpConsumption = 50, skill3SpConsumption = 30, skill4SpConsumption = 30;

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
        beginTransaction();
        newEnemyAtk = (int)(enemyAtk*1.1);
        commitTransaction(skill1SpConsumption);
    }

    @Override
    protected void skill2(int[] allStatus) {
        beginTransaction();
        newEnemyHp = enemyHp + calculateHp(baseHp)/8;
        commitTransaction(skill2SpConsumption);
    }

    @Override
    protected void skill3(int[] allStatus) {
        beginTransaction();
        newPlayerHp = playerHp - calculateDamage(enemyAtk);
        newBreakNum = calculateBreakNum(breakNum);
        commitTransaction(skill3SpConsumption);
    }

    @Override
    protected void skill4(int[] allStatus) {
        beginTransaction();
        newEnemyMaxSp = enemyMaxSp + 10;
        newBreakNum = calculateBreakNum(breakNum);
        commitTransaction(skill4SpConsumption);
    }

    @Override
    public int[] setEnemyBehavior(int[] tempAllStatus) {
        setTempAllStatus(tempAllStatus);
        beginTransaction();
        //int型にキャストしているため10以上の数字を入れること与えられた数字の比がスキルの優先度の比になる　
        chooseSkillWithinSp(10, 10, 40, 10);
        return allStatus;
    }
}
