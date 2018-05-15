package com.example.minor.prototype10.Items.ImportantItems;

import android.widget.Toast;

import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.MainActivity;

/**
 * ベンチの材料はレベル30あたりで手に入り、修理すると幽霊の笑い声が聞こえます。
 * もしブランコが修理されている状態であればイベントが始まります。
 * イベントの処理をこれから書く
 */
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
                importantItemName = importantItemNames.where().equalTo("itemName", "ベンチの材料").findFirst();
                realm.beginTransaction();
                importantItemName.deleteFromRealm();
                realm.commitTransaction();
            } catch (Exception e) {
                realm.cancelTransaction();
            }
        }
        Toast toast = Toast.makeText(MainActivity.context, "ベンチが治った。", Toast.LENGTH_SHORT);
        toast.show();
        realm.close();
    }
}
