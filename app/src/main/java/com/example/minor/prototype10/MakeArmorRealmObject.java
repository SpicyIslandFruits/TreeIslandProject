package com.example.minor.prototype10;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.ArmorId;
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
    private ArmorId armorId;

    //現在は問答無用で強い方の防具を作成しているが、実際は確認ダイヤログを出す
    public boolean createNewArmor(int id){
        boolean newArmorFlag = false;
        realm = Realm.getDefaultInstance();
        makeData = new MakeData();
        superArmor = makeData.makeArmorFromId(id);
        newArmorDf = calculateDf(superArmor.getDf());
        try{
            realm.beginTransaction();
            armorId = realm.createObject(ArmorId.class, new Integer(id));
            armorId.setArmorDf(newArmorDf);
            armorId.setArmorLevel(armorLevel);
            playerInfo.getArmorIds().add(armorId);
            realm.commitTransaction();
            newArmorFlag = true;
        }catch (Exception e){
            realm.cancelTransaction();
            armorId = realm.where(ArmorId.class).findFirst();
            if(armorId.getArmorDf() <= newArmorDf){
                realm.beginTransaction();
                armorId.setArmorDf(newArmorDf);
                armorId.setArmorLevel(armorLevel);
                realm.commitTransaction();
                newArmorFlag = true;
            }
        }
        realm.close();
        return newArmorFlag;
    }

    //かける10となっているところは後で修正する可能性あり、これは特定の階層と次の階層のbaseEnemyLevelの差である
    public int calculateDf(int df){
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        armorLevel = (playerInfo.getBaseEnemyLevel()) + (int)(Math.random()*10);
        df = df*(armorLevel)/100 + 5;
        return df;
    }
}
