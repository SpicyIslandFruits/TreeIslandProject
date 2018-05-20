package com.example.minor.prototype10.Items.Amulets;

import com.example.minor.prototype10.Items.SuperItem;

//装飾品はMPとLUKとSPのみ上げる
public class SampleAmulet extends SuperItem {
    private static final String name = "SampleAmulet";
    private static final String information = "Lukが100パーセント増加。";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return information;
    }

    //アイテムを取得する処理を書くときにこのメソッドを実行する。
    @Override
    public void putOnAmulet() {
        super.putOnAmulet();
        realm.beginTransaction();
        playerInfo.setfLUK(playerInfo.getfLUK()+100);
        realm.commitTransaction();
    }
}
