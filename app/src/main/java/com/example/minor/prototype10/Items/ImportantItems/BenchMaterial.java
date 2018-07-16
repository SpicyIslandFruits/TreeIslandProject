package com.example.minor.prototype10.Items.ImportantItems;

import android.widget.Toast;

import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBenchButton;

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
        if(playerInfo.getPosition() == 19 || playerInfo.getPosition() == 21 || playerInfo.getPosition() == 22) {
            try {
                importantItemName = importantItemNames.where().equalTo("itemName", "ベンチの材料").findFirst();
                realm.beginTransaction();
                importantItemName.deleteFromRealm();
                realm.commitTransaction();
                Toast toast = Toast.makeText(MainActivity.context, "ベンチが治った。", Toast.LENGTH_SHORT);
                toast.show();
                editor.putInt("oldMansionGardenBenchState", 2);
                editor.apply();
                OnClickBenchButton onClickBenchButton = new OnClickBenchButton();
                onClickBenchButton.createMap();
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
