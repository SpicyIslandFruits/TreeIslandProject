package com.example.minor.prototype10;

import com.example.minor.prototype10.Armors.SampleArmor;
import com.example.minor.prototype10.Armors.SampleArmor2;
import com.example.minor.prototype10.Armors.SuperArmor;
import com.example.minor.prototype10.Enemys.SampleEnemy;
import com.example.minor.prototype10.Enemys.SampleEnemy2;
import com.example.minor.prototype10.Enemys.SampleEnemy3;
import com.example.minor.prototype10.Enemys.SuperEnemy;
import com.example.minor.prototype10.Items.Amulets.SampleAmulet;
import com.example.minor.prototype10.Items.ImportantItems.BenchMaterial;
import com.example.minor.prototype10.Items.ImportantItems.BurankoMaterial;
import com.example.minor.prototype10.Items.ImportantItems.GardenCornerKey;
import com.example.minor.prototype10.Items.OtherItems.SampleOtherItem;
import com.example.minor.prototype10.Items.OtherItems.SampleOtherItem2;
import com.example.minor.prototype10.Items.RecoveryItems.Bandage;
import com.example.minor.prototype10.Items.RecoveryItems.HpAnalepticumSmall;
import com.example.minor.prototype10.Items.RecoveryItems.MpAnalepticumSmall;
import com.example.minor.prototype10.Items.RecoveryItems.Antidote;
import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBBBothRepairedEvtButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBBEitherOneRepairedEvtButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBackDoorButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBathButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBedButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBedroomButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBenchButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBenchNisuwaruButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBookshelfButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBossRoomButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBurankoButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBurankoNisuwaruButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickDungeon2FButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickDungeonButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEmptyButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtBackDoorButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtBedroomButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtBenchButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtBenchNisuwaruButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtBookshelfButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtBurankoButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtBurankoNisuwaruButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtGardenCornerButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtIdoButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtMansion1FButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtStudyButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtStudyTableButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEvtWarehouseButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickGardenButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickGardenCornerButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickIdoButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickInnButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickKitchenButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickMoneyThrowButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickOldMansion1FButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickOldMansion2FButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickOldMansionEnterBasementButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickOldMansionButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickOldMansionInBasementButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickOshiireButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickPassButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickRooftopButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickStudyButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickStudyTableButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickTownButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickWarehouseButton;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickEnterTown1FButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FObservatoryMapButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetAButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetA_1Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetA_2Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetBButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetCButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetC_1Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetC_2Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetC_3Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetC_4Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetDButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetEButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetE_1Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetE_2Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetFButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetF_1Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetF_2Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetGButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetG_1Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetG_2Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetG_3Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetHButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetIButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetJButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetJ_1Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetJ_2Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetJ_3Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetJ_4Button;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickTown1FStreetKButton;
import com.example.minor.prototype10.PlayerSkill.SampleSkill;
import com.example.minor.prototype10.PlayerSkill.SampleSkill2;
import com.example.minor.prototype10.PlayerSkill.SuperSkill;
import com.example.minor.prototype10.Weapons.SampleWeapon;
import com.example.minor.prototype10.Weapons.SampleWeapon2;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.Realm;

/**
 * パッケージにクラスを追加したらここにswitch文を追加する
 * どのメソッドもreturn分を含むのでvoidを変える
 * 武器防具は重複不可、同一武器を拾った場合は捨てたり換金したり
 * アイテムもPrimaryKeyが名前になっているのでこのままだと重複不可あとで何とかする
 */
public class MakeData {
    private static final int playerBaseStatus = 120;
    private Realm realm;
    private PlayerInfo playerInfo;

    //マップを追加したときはここに書く
    public SuperOnClickMapButton makeMapFromPosition(int position){
        SuperOnClickMapButton onClickMapButton = new OnClickInnButton();
        switch (position){
            case 0:
                onClickMapButton = new OnClickInnButton();
                break;
            case 1:
                onClickMapButton = new OnClickTownButton();
                break;
            case 2:
                onClickMapButton = new OnClickDungeonButton();
                break;
            case 3:
                onClickMapButton = new OnClickBossRoomButton();
                break;
            case 4:
                onClickMapButton = new OnClickDungeon2FButton();
                break;
            case 5:
                onClickMapButton = new OnClickPassButton();
                break;
            case 6:
                onClickMapButton = new OnClickOldMansionButton();
                break;
            case 7:
                onClickMapButton = new OnClickEmptyButton();
                break;
            case 8:
                onClickMapButton = new OnClickOldMansion1FButton();
                break;
            case 9:
                onClickMapButton = new OnClickKitchenButton();
                break;
            case 10:
                onClickMapButton = new OnClickBathButton();
                break;
            case 11:
                onClickMapButton = new OnClickOldMansion2FButton();
                break;
            case 12:
                onClickMapButton = new OnClickRooftopButton();
                break;
            case 13:
                onClickMapButton = new OnClickBedroomButton();
                break;
            case 14:
                onClickMapButton = new OnClickWarehouseButton();
                break;
            case 15:
                onClickMapButton = new OnClickStudyButton();
                break;
            case 16:
                onClickMapButton = new OnClickOshiireButton();
                break;
            case 17:
                onClickMapButton = new OnClickBedButton();
                break;
            case 18:
                onClickMapButton = new OnClickBackDoorButton();
                break;
            case 19:
                onClickMapButton = new OnClickGardenButton();
                break;
            case 20:
                onClickMapButton = new OnClickGardenCornerButton();
                break;
            case 21:
                onClickMapButton = new OnClickBenchButton();
                break;
            case 22:
                onClickMapButton = new OnClickBenchNisuwaruButton();
                break;
            case 23:
                onClickMapButton = new OnClickBurankoButton();
                break;
            case 24:
                onClickMapButton = new OnClickBurankoNisuwaruButton();
                break;
            case 25:
                onClickMapButton = new OnClickIdoButton();
                break;
            case 26:
                onClickMapButton = new OnClickBBEitherOneRepairedEvtButton();
                break;
            case 27:
                onClickMapButton = new OnClickBBBothRepairedEvtButton();
                break;
            case 28:
                onClickMapButton = new OnClickEvtBenchButton();
                break;
            case 29:
                onClickMapButton = new OnClickEvtBenchNisuwaruButton();
                break;
            case 30:
                onClickMapButton = new OnClickEvtBurankoButton();
                break;
            case 31:
                onClickMapButton = new OnClickEvtBurankoNisuwaruButton();
                break;
            case 32:
                onClickMapButton = new OnClickEvtIdoButton();
                break;
            case 33:
                onClickMapButton = new OnClickEvtMansion1FButton();
                break;
            case 34:
                onClickMapButton = new OnClickMoneyThrowButton();
                break;
            case 35:
                onClickMapButton = new OnClickEvtBackDoorButton();
                break;
            case 36:
                onClickMapButton = new OnClickEvtWarehouseButton();
                break;
            case 37:
                onClickMapButton = new OnClickEvtStudyButton();
                break;
            case 38:
                onClickMapButton = new OnClickEvtBookshelfButton();
                break;
            case 39:
                onClickMapButton = new OnClickBookshelfButton();
                break;
            case 40:
                onClickMapButton = new OnClickOldMansionEnterBasementButton();
                break;
            case 41:
                onClickMapButton = new OnClickStudyTableButton();
                break;
            case 42:
                onClickMapButton = new OnClickEvtStudyTableButton();
                break;
            case 43:
                onClickMapButton = new OnClickEvtBedroomButton();
                break;
            case 44:
                onClickMapButton = new OnClickEvtGardenCornerButton();
                break;
            case 45:
                onClickMapButton = new OnClickOldMansionInBasementButton();
                break;
            case 10001:
                onClickMapButton = new OnClickEnterTown1FButton();
                break;
            case 10002:
                onClickMapButton = new OnClickTown1FStreetAButton();
                break;
            case 10003:
                onClickMapButton = new OnClickTown1FObservatoryMapButton();
                break;
            case 10004:
                onClickMapButton = new OnClickTown1FStreetA_1Button();
                break;
            case 10005:
                onClickMapButton = new OnClickTown1FStreetBButton();
                break;
            case 10006:
                onClickMapButton = new OnClickTown1FStreetA_2Button();
                break;
            case 10007:
                onClickMapButton = new OnClickTown1FStreetCButton();
                break;
            case 10008:
                onClickMapButton = new OnClickTown1FStreetDButton();
                break;
            case 10009:
                onClickMapButton = new OnClickTown1FStreetC_1Button();
                break;
            case 10010:
                onClickMapButton = new OnClickTown1FStreetC_2Button();
                break;
            case 10011:
                onClickMapButton = new OnClickTown1FStreetC_3Button();
                break;
            case 10012:
                onClickMapButton = new OnClickTown1FStreetC_4Button();
                break;
            case 10013:
                onClickMapButton = new OnClickTown1FStreetEButton();
                break;
            case 10014:
                onClickMapButton = new OnClickTown1FStreetFButton();
                break;
            case 10015:
                onClickMapButton = new OnClickTown1FStreetE_1Button();
                break;
            case 10016:
                onClickMapButton = new OnClickTown1FStreetE_2Button();
                break;
            case 10017:
                onClickMapButton = new OnClickTown1FStreetF_1Button();
                break;
            case 10018:
                onClickMapButton = new OnClickTown1FStreetF_2Button();
                break;
            case 10019:
                onClickMapButton = new OnClickTown1FStreetGButton();
                break;
            case 10020:
                onClickMapButton = new OnClickTown1FStreetHButton();
                break;
            case 10021:
                onClickMapButton = new OnClickTown1FStreetG_1Button();
                break;
            case 10022:
                onClickMapButton = new OnClickTown1FStreetG_2Button();
                break;
            case 10023:
                onClickMapButton = new OnClickTown1FStreetG_3Button();
                break;
            case 10024:
                onClickMapButton = new OnClickTown1FStreetIButton();
                break;
            case 10025:
                onClickMapButton = new OnClickTown1FStreetJButton();
                break;
            case 10026:
                onClickMapButton = new OnClickTown1FStreetJ_1Button();
                break;
            case 10027:
                onClickMapButton = new OnClickTown1FStreetJ_2Button();
                break;
            case 10028:
                onClickMapButton = new OnClickTown1FStreetJ_3Button();
                break;
            case 10029:
                onClickMapButton = new OnClickTown1FStreetJ_4Button();
                break;
            case 10030:
                onClickMapButton = new OnClickTown1FStreetKButton();
                break;
                //break忘れるな
        }

        return onClickMapButton;
    }

    //レベルを受け取ってステータスを生成しRealmに渡す
    //lukとspとmpはレベルによって変化はしない
    //lukに関しては装飾品やスキル、フィールドバフによって変化するが能力値は一定でlukの数値がそのままクリティカル率になる。また、ごみをあさるなどでアイテムを取得できる確率もluk
    //mpとspはゲージでのみ表示し、数値は出さない
    //setMaxHpの最後の2つの数字はそれぞれ主人公が同じレベルの敵を平均何回の平均的な攻撃で倒せるか(此処を変更した場合superEnemyの数字も変更)、hpがマックスの状態から何体の敵を倒せるかを表す
    public void makePlayerStatusFromLevel(int level){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        realm.beginTransaction();
        playerInfo.setMaxHP((playerBaseStatus*level/100+level+10) * 4 * 4);
        playerInfo.setDF(playerBaseStatus*level/100+5);
        playerInfo.setATK(playerBaseStatus*level/100+5);
        realm.commitTransaction();
        realm.close();
    }

    //プレイヤースキルを追加した場合はここに書く
    public SuperSkill makePlayerSkillFromName(String skillName){
        SuperSkill skill = new SampleSkill();
        switch (skillName){
            case "SamplePlayerSkill":
                skill = new SampleSkill();
                break;
            case "SamplePlayerSkill2":
                skill = new SampleSkill2();
                break;
        }
        return skill;
    }

    //idを受け取って敵クラスのインスタンスを返しますmakeWeaponFromIdを参照して書いてください
    public SuperEnemy makeEnemyFromId(int id){
        SuperEnemy enemy = new SampleEnemy3();
        switch (id){
            case 0:
                enemy = new SampleEnemy3();
                break;
            case 1:
                enemy = new SampleEnemy();
                break;
            case 2:
                enemy = new SampleEnemy2();
                break;
        }
        return enemy;
    }

    /**
     * 武器を追加した場合はここに書く
     * 現在のままだとweaponNameがないときにエラーが出る。
     */
    public SuperWeapon makeWeaponFromName(String weaponName){
        SuperWeapon weapon = new SampleWeapon();
        switch (weaponName){
            case "SampleWeapon":
                weapon = new SampleWeapon();
                break;
            case "SampleWeapon2":
                weapon = new SampleWeapon2();
                break;
        }
        return weapon;
    }

    //防具を追加した場合はここに書く
    public SuperArmor makeArmorFromName(String armorName){
        SuperArmor armor = new SampleArmor();
        switch (armorName){
            case "SampleArmor":
                armor = new SampleArmor();
                break;
            case "SampleArmor2":
                armor = new SampleArmor2();
                break;
        }
        return armor;
    }

    //アイテムを追加した場合はここに書く
    //Realmに保存されている名前から、アイテムのインスタンスを作ります。文字列でswitchさせます。
    //アイテムを追加したときはここに処理を追加
    public SuperItem makeItemFromName(String itemName){
        SuperItem item = new BenchMaterial();
        switch (itemName){
            case "ベンチの材料":
                item = new BenchMaterial();
                break;
            case "ブランコの材料":
                item = new BurankoMaterial();
                break;
            case "HP回復薬小":
                item = new HpAnalepticumSmall();
                break;
            case "MP回復薬小":
                item = new MpAnalepticumSmall();
                break;
            case "SampleAmulet":
                item = new SampleAmulet();
                break;
            case "解毒薬":
                item = new Antidote();
                break;
            case "包帯":
                item = new Bandage();
                break;
            case "地下室の鍵":
                item = new GardenCornerKey();
                break;
            case "SampleOtherItem":
                item = new SampleOtherItem();
                break;
            case "SampleOtherItem2":
                item = new SampleOtherItem2();
                break;
        }
        return item;
    }
}
