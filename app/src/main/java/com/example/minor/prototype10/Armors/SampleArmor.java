package com.example.minor.prototype10.Armors;

/**
 * スキルにはRealmのHpの値を直接編集するものをセット,sp,mp,hp,lukに対しての操作が可能
 * defは別で処理するのでスキル内に書いてはいけない
 * 防具スキルを本格的に実装する場合、まずバトルアクティビティにオートスキルメソッドを実装する
 * オートスキルメソッドでは、装備中の防具のインスタンスを取得し、すべてのスキルを実行する
 * バトルアクティビティのexecuteTempBattleの中にオートスキルメソッドの実行を書く
 */
public class SampleArmor extends SuperArmor {
    private static final int id = 0;
    private static final String name = "SampleArmor";
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