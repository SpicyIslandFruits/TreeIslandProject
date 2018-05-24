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
import com.example.minor.prototype10.Items.RecoveryItems.Bandage;
import com.example.minor.prototype10.Items.RecoveryItems.HpAnalepticumSmall;
import com.example.minor.prototype10.Items.RecoveryItems.MpAnalepticumSmall;
import com.example.minor.prototype10.Items.RecoveryItems.Antidote;
import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBBBothRepairedEvtButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBBEitherOneRepairedEvtButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBackDoorButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBathButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBedButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBedroomButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBenchButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBenchNisuwaruButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBookshelfButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBossRoomButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBurankoButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBurankoNisuwaruButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickDungeon2FButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickDungeonButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEmptyButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtBackDoorButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtBenchButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtBenchNisuwaruButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtBookshelfButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtBurankoButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtBurankoNisuwaruButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtIdoButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtMansion1FButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtStudyButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickEvtWarehouseButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickGardenButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickGardenCornerButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickIdoButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickInnButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickKitchenButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickMoneyThrowButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickOldMansion1FButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickOldMansion2FButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickOldMansionButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickOshiireButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickPassButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickRooftopButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickStudyButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickTownButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickWarehouseButton;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
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

    //武器を追加した場合はここに書く
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
        }
        return item;
    }
}
