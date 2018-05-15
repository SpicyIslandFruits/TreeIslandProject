package com.example.minor.prototype10.Items.RecoveryItems;

import android.widget.Toast;

import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.MainActivity;

/**
 * 回復薬の入手方法は
 * recoveryItemName = realm.createObject(RecoveryItemName.class);
 * recoveryItemName.setItemName("名前");
 * を書く
 */
public class HpAnalepticumSmall extends SuperItem{
    private static final String name = "HP回復薬小";
    private static final String information = "HPを小回復";

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
        //あとで回復音をつける
        realm.beginTransaction();
        if(playerInfo.getHP() + playerInfo.getFmaxHP()/4 >= playerInfo.getFmaxHP()){
            playerInfo.setHP(playerInfo.getFmaxHP());
        }else {
            playerInfo.setHP(playerInfo.getHP() + playerInfo.getFmaxHP() / 4);
        }
        recoveryItemName = recoveryItemNames.where().equalTo("itemName", "HP回復薬小").findFirst();
        recoveryItemName.deleteFromRealm();
        realm.commitTransaction();
        Toast toast = Toast.makeText(MainActivity.context, "HPが回復した。", Toast.LENGTH_SHORT);
        toast.show();
        realm.close();
    }
}
