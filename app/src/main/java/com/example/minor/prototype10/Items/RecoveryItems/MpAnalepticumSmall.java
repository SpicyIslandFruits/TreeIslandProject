package com.example.minor.prototype10.Items.RecoveryItems;

import android.widget.Toast;

import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.MainActivity;

public class MpAnalepticumSmall extends SuperItem{
    private static final String name = "MP回復薬小";
    private static final String information = "MPを小回復";

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
        if(playerInfo.getMP() + playerInfo.getFmaxMP()/4 >= playerInfo.getFmaxMP()){
            playerInfo.setMP(playerInfo.getFmaxMP());
        }else {
            playerInfo.setMP(playerInfo.getMP() + playerInfo.getFmaxMP() / 4);
        }
        recoveryItemName = recoveryItemNames.where().equalTo("itemName", "MP回復薬小").findFirst();
        recoveryItemName.deleteFromRealm();
        realm.commitTransaction();
        Toast toast = Toast.makeText(MainActivity.context, "MPが回復した。", Toast.LENGTH_SHORT);
        toast.show();
        realm.close();
    }
}
