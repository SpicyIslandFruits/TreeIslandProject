package com.example.minor.prototype10.Items.ImportantItems;

import android.widget.Toast;

import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickGardenCornerButton;

public class GardenCornerKey extends SuperItem {
    private static final String name = "地下室の鍵";
    private static final String information = "庭の隅で使用できます。";
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
        if(playerInfo.getPosition() == 20 || playerInfo.getPosition() == 19) {
            try {
                importantItemName = importantItemNames.where().equalTo("itemName", "地下室の鍵").findFirst();
                realm.beginTransaction();
                importantItemName.deleteFromRealm();
                realm.commitTransaction();
                editor.putBoolean("oldMansionBasementOpenFlag", true);
                editor.apply();
                Toast toast = Toast.makeText(MainActivity.context, "鍵を使った。", Toast.LENGTH_SHORT);
                toast.show();
                OnClickGardenCornerButton onClickGardenCornerButton = new OnClickGardenCornerButton();
                onClickGardenCornerButton.createMap();
            } catch (Exception e) {
                realm.cancelTransaction();
            }
        }else{
            Toast toast = Toast.makeText(MainActivity.context, "ここでは使用できません。", Toast.LENGTH_SHORT);
            toast.show();
        }
        realm.close();
    }
}
