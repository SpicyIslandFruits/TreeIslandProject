package com.example.minor.prototype10.Enemys;

public class SampleEnemy2 extends SuperEnemy{
    private static final int id = 2, baseHp = 1000, sp = 100, baseAtk = 120, baseDf = 120, luk = 100;
    private static final String enemySkills = "何もしてこない敵です、ダメージ計算に使用してくださ";

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
        commitTransaction(0);
    }

    @Override
    protected void skill2(int[] allStatus) {
        beginTransaction();
        commitTransaction(0);
    }

    @Override
    protected void skill3(int[] allStatus) {
        beginTransaction();
        commitTransaction(0);
    }

    @Override
    protected void skill4(int[] allStatus) {
        beginTransaction();
        commitTransaction(0);
    }

    @Override
    public int[] setEnemyBehavior(int[] tempAllStatus) {
        setTempAllStatus(tempAllStatus);
        beginTransaction();
        return allStatus;
    }

    @Override
    protected void chooseSkillWithinSp(int skill1Priority, int skill2Priority, int skill3Priority, int skill4Priority) {

    }
}
