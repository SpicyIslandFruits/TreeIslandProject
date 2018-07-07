package com.example.minor.prototype10;

import com.example.minor.prototype10.Models.ArmorName;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Armors.SuperArmor;

import io.realm.Realm;

/**
 * 武器クラス参照
 */
public class MakeArmorRealmObject {
    private MakeData makeData;
    private SuperArmor superArmor;
    private int newArmorDf;
    private PlayerInfo playerInfo;
    private Realm realm;
    private int armorLevel;
    private ArmorName armorName;

    //同じ名前の武器がある場合それを捨てる処理を書く
    public void createNewArmor(String armorName){
        realm = Realm.getDefaultInstance();
        makeData = new MakeData();
        superArmor = makeData.makeArmorFromName(armorName);
        newArmorDf = calculateDf(superArmor.getDf());
        realm.beginTransaction();
        this.armorName = realm.createObject(ArmorName.class);
        this.armorName.setArmorName(armorName);
        this.armorName.setArmorDf(newArmorDf);
        this.armorName.setArmorLevel(armorLevel);
        playerInfo.setArmorName(armorName);
        realm.commitTransaction();
        realm.close();
    }

    //かける10となっているところは後で修正する可能性あり、これは特定の階層と次の階層のbaseEnemyLevelの差である
    public int calculateDf(int df){
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        armorLevel = (playerInfo.getBaseEnemyLevel()) + (int)(Math.random()*10);
        df = df*(armorLevel)/100 + 5;
        return df;
    }
}
