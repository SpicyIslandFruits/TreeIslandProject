package com.example.minor.prototype10.Items.RecoveryItems;

import android.widget.Toast;

import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.Activities.MainActivity;

public class Bandage extends SuperItem {
    private static final String name = "包帯";
    private static final String information = "出血状態を治す";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return information;
    }

    @Override
    public void useRecoveryItem() {
        super.useRecoveryItem();
        //ここに回復処理を書く
        realm.beginTransaction();
        playerInfo.setBleedingFlag(false);
        recoveryItemName = recoveryItemNames.where().equalTo("itemName", "包帯").findFirst();
        recoveryItemName.deleteFromRealm();
        realm.commitTransaction();
        Toast toast = Toast.makeText(MainActivity.context, "止血した", Toast.LENGTH_SHORT);
        toast.show();
        realm.close();
    }
}
