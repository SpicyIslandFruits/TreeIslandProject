package com.example.minor.prototype10.Armors;

public class SampleArmor2 extends SuperArmor {
    private static final int id = 1;
    private static final String name = "SampleArmor2";
    private static final int df = 120;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getDf() {
        return df;
    }

    @Override
    public String getSkill1Info() {
        return null;
    }

    @Override
    public String getSkill2Info() {
        return null;
    }

    @Override
    public String getSkill3Info() {
        return null;
    }

    @Override
    public String getSkill1Name() {
        return null;
    }

    @Override
    public String getSkill2Name() {
        return null;
    }

    @Override
    public String getSkill3Name() {
        return null;
    }

    @Override
    public void skill1() {

    }

    @Override
    public void skill2() {

    }

    @Override
    public void skill3() {

    }
}
