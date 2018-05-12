package com.example.minor.prototype10.Items.ImportantItems;

import com.example.minor.prototype10.Items.SuperItem;

public class BenchMaterial extends SuperItem{
    private static final String name = "ベンチの材料";
    private static final String information = "庭で使用できます。";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return information;
    }


    @Override
    public void useMaterial() {
        super.useMaterial();
        editor.putInt("oldMansionGardenBenchState", 2);
        editor.apply();
        if(playerInfo.getPosition() == 19 || playerInfo.getPosition() == 21 || playerInfo.getPosition() == 22) {
            try {
                importantItemId = importantItemIds.where().equalTo("itemName", "ベンチの材料").findFirst();
                realm.beginTransaction();
                importantItemId.deleteFromRealm();
                realm.commitTransaction();
            } catch (Exception e) {
                realm.cancelTransaction();
            }
        }
    }
}
