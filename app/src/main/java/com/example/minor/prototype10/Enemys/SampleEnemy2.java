package com.example.minor.prototype10.Enemys;

public class SampleEnemy2 extends SuperEnemy{
    private static final int id = 2, baseHp = 120, sp = 100, baseAtk = 120, baseDf = 120, luk = 100;
    private static final String enemySkills = "毒状態にしたり、出血させたりしてきます";

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
        poison();
        commitTransaction(40);
    }

    @Override
    protected void skill2(int[] allStatus) {
        beginTransaction();
        bleeding();
        commitTransaction(40);
    }

    @Override
    protected void skill3(int[] allStatus) {
        beginTransaction();
        newPlayerHp = playerHp - calculateDamage(enemyAtk);
        newBreakNum = calculateBreakNum(breakNum);
        commitTransaction(30);
    }


    @Override
    protected void skill4(int[] allStatus) {
        beginTransaction();
        newEnemyDf = (int)(enemyDf*1.2);
        commitTransaction(30);
    }

    @Override
    public int[] setEnemyBehavior(int[] tempAllStatus) {
        setTempAllStatus(tempAllStatus);
        beginTransaction();
        chooseSkillWithinSp(10, 10, 40, 10);
        return allStatus;
    }
}
