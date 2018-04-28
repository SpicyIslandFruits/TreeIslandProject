package com.example.minor.prototype10.PlayerSkill;

public class SampleSkill2 extends SuperSkill {
    private static final int id = 1;
    private static final String name = "SamplePlayerSkill2";
    private static final String skillInfo = "SamplePlayerSkill、Hp自動回復、Hp吸収、毒状態";
    private static final int mpConsumption = 70;
    private static final int spConsumption = 50;

    @Override
    public int[] skill(int[] tempAllStatus) {
        beginTransaction(tempAllStatus);
        setPlayerAutoHealing();
        setPlayerAutoAbsorbing();
        setEnemyPoison();
        commitTransaction(spConsumption, mpConsumption);
        return newAllStatus;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSkillInfo() {
        return skillInfo;
    }

    @Override
    public String getSkillName() {
        return name;
    }
}

