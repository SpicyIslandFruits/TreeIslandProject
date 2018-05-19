package com.example.minor.prototype10.PlayerSkill;

/**
 * 消費spのほかに消費mpも書かなければいけないことに注意書き忘れ厳禁
 * すべてバフや状態異常などのスキルです、全部割合にします(固定値だとバランス調整がめんどい)
 */
public class SampleSkill extends SuperSkill {
    private static final String name = "SamplePlayerSkill";
    private static final String skillInfo = "SamplePlayerSkill、攻撃力アップ";
    private static final int mpConsumption = 20;
    private static final int spConsumption = 50;

    @Override
    public int[] skill(int[] tempAllStatus) {
        beginTransaction(tempAllStatus);
        newPlayerAtk = (int)(playerAtk * 1.1);
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
