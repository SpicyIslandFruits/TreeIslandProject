package com.example.minor.prototype10.PlayerSkill;

/**
 * 消費spのほかに消費mpも書かなければいけないことに注意
 */
public class SampleSkill extends SuperSkill {
    private static final int id = 0;
    private static final String name = "SamplePlayerSkill";
    private static final String skillInfo = "SamplePlayerSkill、攻撃力アップ";
    private static final int mpConsumption = 7;
    private static final int spConsumption = 3;

    @Override
    public int[] skill(int[] tempAllStatus) {
        beginTransaction(tempAllStatus);
        newPlayerAtk = (int)(playerAtk * 1.2);
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
