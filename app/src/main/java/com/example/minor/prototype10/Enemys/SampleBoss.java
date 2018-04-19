package com.example.minor.prototype10.Enemys;

/*skillメソッドにスキルの中身を書き、setEnemyBehaviorメソッドに行動パターンを書いてください*/
public class SampleBoss extends SuperEnemy {
    private static final int hp = 100, sp = 10, atk = 10, df = 100, luk = 100;

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
    public void skill1(int[] tempAllStatus) {
        newPlayerHp = playerHp - enemyAtk;
    }

    @Override
    public void skill2(int[] tempAllStatus) {

    }

    @Override
    public void skill3(int[] tempAllStatus) {

    }

    @Override
    public void skill4(int[] tempAllStatus) {

    }

    @Override
    public int[] setEnemyBehavior(int[] tempAllStatus) {
        beginTransaction(tempAllStatus);
        skill1(tempAllStatus);
        commitTransaction();
        return newAllStatus;
    }
}
