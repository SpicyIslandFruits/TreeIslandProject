package com.example.minor.prototype10.Items.ImportantItems;

import android.widget.Toast;

import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBurankoButton;

/**
 * ブランコの材料はレベル70あたりで手に入り、修理すると幽霊の笑い声が聞こえます。
 * もしベンチが修理されている状態であればイベントが始まります。
 * イベントの処理をこれから書く
 */
public class BurankoMaterial extends SuperItem{
    private static final String name = "ブランコの材料";
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
        if(playerInfo.getPosition() == 19 || playerInfo.getPosition() == 23 || playerInfo.getPosition() == 24) {
            try {
                importantItemName = importantItemNames.where().equalTo("itemName", "ブランコの材料").findFirst();
                realm.beginTransaction();
                importantItemName.deleteFromRealm();
                realm.commitTransaction();
                editor.putInt("oldMansionGardenBurankoState", 2);
                editor.apply();
                Toast toast = Toast.makeText(MainActivity.context, "ブランコが治った。", Toast.LENGTH_SHORT);
                toast.show();
                OnClickBurankoButton onClickBurankoButton = new OnClickBurankoButton();
                onClickBurankoButton.createMap();
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
