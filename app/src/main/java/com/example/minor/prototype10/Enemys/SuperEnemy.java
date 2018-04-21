package com.example.minor.prototype10.Enemys;

abstract public class SuperEnemy {
    protected int playerHp, playerMp, playerSp, playerAtk, playerDf, playerLuk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk, breakNum;
    protected int newPlayerHp, newPlayerMp, newPlayerSp, newPlayerAtk, newPlayerDf, newPlayerLuk, newEnemyHp, newEnemySp, newEnemyAtk, newEnemyDf, newEnemyLuk, newBreakNum;
    protected int[] newAllStatus, tempAllStatus;

    protected void beginTransaction(int[] tempAllStatus){
        newAllStatus = new int[12];
        newPlayerHp = playerHp = tempAllStatus[0];
        newPlayerMp = playerMp = tempAllStatus[1];
        newPlayerSp = playerSp = tempAllStatus[2];
        newPlayerAtk = playerAtk = tempAllStatus[3];
        newPlayerDf = playerDf = tempAllStatus[4];
        newPlayerLuk = playerLuk = tempAllStatus[5];
        newEnemyHp = enemyHp = tempAllStatus[6];
        newEnemySp = enemySp = tempAllStatus[7];
        newEnemyAtk = enemyAtk = tempAllStatus[8];
        newEnemyDf = enemyDf = tempAllStatus[9];
        newEnemyLuk = enemyLuk = tempAllStatus[10];
        newBreakNum = breakNum = tempAllStatus[11];
    }

    protected void commitTransaction(){
        newAllStatus[0] = newPlayerHp;
        newAllStatus[1] = newPlayerMp;
        newAllStatus[2] = newPlayerSp;
        newAllStatus[3] = newPlayerAtk;
        newAllStatus[4] = newPlayerDf;
        newAllStatus[5] = newPlayerLuk;
        newAllStatus[6] = newEnemyHp;
        newAllStatus[7] = newEnemySp;
        newAllStatus[8] = newEnemyAtk;
        newAllStatus[9] = newEnemyDf;
        newAllStatus[10] = newEnemyLuk;
        newAllStatus[11] = newBreakNum;
    }
    abstract public int getHp();
    abstract public int getSp();
    abstract public int getAtk();
    abstract public int getDf();
    abstract public int getLuk();
    abstract protected void skill1(int[] tempAllStatus);
    abstract protected void skill2(int[] tempAllStatus);
    abstract protected void skill3(int[] tempAllStatus);
    abstract protected void skill4(int[] tempAllStatus);
    abstract public int[] setEnemyBehavior(int[] tempAllStatus);

}
