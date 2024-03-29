package com.example.minor.prototype10.Models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/*
* f...は武器を装備した状態のステータス
* m...はフィールドバフがかかった状態のステータス
*/
public class PlayerInfo extends RealmObject {
    @PrimaryKey
    private String player;

    private int playerLevel;
    private int experiencePointSum;
    private int position;
    private int formerPosition;
    private int money;
    private int maxHP;
    private int fmaxHP;
    private int HP;
    private int maxMP;
    private int fmaxMP;
    private int MP;
    private int SP;
    private int fSP;
    private int ATK;
    private int fATK;
    private int DF;
    private int fDF;
    private int LUK;
    private int fLUK;
    private String weaponName;
    private String armorName;
    private RealmList<WeaponName> warehouseWeapons;
    private RealmList<WeaponName> equippedWeapons;
    private RealmList<ArmorName> warehouseArmors;
    private RealmList<ArmorName> equippedArmors;
    private RealmList<RecoveryItemName> equippedRecoveryItems;
    private RealmList<RecoveryItemName> warehouseRecoveryItems;
    private RealmList<OtherItemName> equippedOtherItems;
    private RealmList<OtherItemName> warehouseOtherItems;
    private int playerSkill1;
    private int playerSkill2;
    private int playerSkill3;
    private int playerSkill4;
    private int baseEnemyLevel;
    private int additionalEnemyLevel;
    private boolean battleFlag;
    private int lastAffrontEnemy;
    private boolean poisonFlag;
    private boolean bleedingFlag;
    private boolean enemyPoisonFlag;
    private boolean playerAutoHealingFlag;
    private boolean playerAutoAbsorbingFlag;
    private boolean playerSuicideFlag;
    private int idoMoneyCount;
    private String nowPlayingBgmName;

    public RealmList<OtherItemName> getEquippedOtherItems() {
        return equippedOtherItems;
    }

    public void setEquippedOtherItems(RealmList<OtherItemName> equippedOtherItems) {
        this.equippedOtherItems = equippedOtherItems;
    }

    public RealmList<OtherItemName> getWarehouseOtherItems() {
        return warehouseOtherItems;
    }

    public void setWarehouseOtherItems(RealmList<OtherItemName> warehouseOtherItems) {
        this.warehouseOtherItems = warehouseOtherItems;
    }

    public RealmList<RecoveryItemName> getEquippedRecoveryItems() {
        return equippedRecoveryItems;
    }

    public void setEquippedRecoveryItems(RealmList<RecoveryItemName> equippedRecoveryItems) {
        this.equippedRecoveryItems = equippedRecoveryItems;
    }

    public RealmList<RecoveryItemName> getWarehouseRecoveryItems() {
        return warehouseRecoveryItems;
    }

    public void setWarehouseRecoveryItems(RealmList<RecoveryItemName> warehouseRecoveryItems) {
        this.warehouseRecoveryItems = warehouseRecoveryItems;
    }

    public RealmList<ArmorName> getWarehouseArmors() {
        return warehouseArmors;
    }

    public void setWarehouseArmors(RealmList<ArmorName> warehouseArmors) {
        this.warehouseArmors = warehouseArmors;
    }

    public RealmList<ArmorName> getEquippedArmors() {
        return equippedArmors;
    }

    public void setEquippedArmors(RealmList<ArmorName> equippedArmors) {
        this.equippedArmors = equippedArmors;
    }

    public RealmList<WeaponName> getWarehouseWeapons() {
        return warehouseWeapons;
    }

    public void setWarehouseWeapons(RealmList<WeaponName> warehouseWeapons) {
        this.warehouseWeapons = warehouseWeapons;
    }

    public RealmList<WeaponName> getEquippedWeapons() {
        return equippedWeapons;
    }

    public void setEquippedWeapons(RealmList<WeaponName> equippedWeapons) {
        this.equippedWeapons = equippedWeapons;
    }

    public String getNowPlayingBgmName() {
        return nowPlayingBgmName;
    }

    public void setNowPlayingBgmName(String nowPlayingBgmName) {
        this.nowPlayingBgmName = nowPlayingBgmName;
    }

    public int getIdoMoneyCount() {
        return idoMoneyCount;
    }

    public void setIdoMoneyCount(int idoMoneyCount) {
        this.idoMoneyCount = idoMoneyCount;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getExperiencePointSum() {
        return experiencePointSum;
    }

    public void setExperiencePointSum(int experiencePointSum) {
        this.experiencePointSum = experiencePointSum;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getFmaxHP() {
        return fmaxHP;
    }

    public void setFmaxHP(int fmaxHP) {
        this.fmaxHP = fmaxHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getFmaxMP() {
        return fmaxMP;
    }

    public void setFmaxMP(int fmaxMP) {
        this.fmaxMP = fmaxMP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getfSP() {
        return fSP;
    }

    public void setfSP(int fSP) {
        this.fSP = fSP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getfATK() {
        return fATK;
    }

    public void setfATK(int fATK) {
        this.fATK = fATK;
    }

    public int getDF() {
        return DF;
    }

    public void setDF(int DF) {
        this.DF = DF;
    }

    public int getfDF() {
        return fDF;
    }

    public void setfDF(int fDF) {
        this.fDF = fDF;
    }

    public int getLUK() {
        return LUK;
    }

    public void setLUK(int LUK) {
        this.LUK = LUK;
    }

    public int getfLUK() {
        return fLUK;
    }

    public void setfLUK(int fLUK) {
        this.fLUK = fLUK;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getPlayerSkill1() {
        return playerSkill1;
    }

    public void setPlayerSkill1(int playerSkill1) {
        this.playerSkill1 = playerSkill1;
    }

    public int getPlayerSkill2() {
        return playerSkill2;
    }

    public void setPlayerSkill2(int playerSkill2) {
        this.playerSkill2 = playerSkill2;
    }

    public int getPlayerSkill3() {
        return playerSkill3;
    }

    public void setPlayerSkill3(int playerSkill3) {
        this.playerSkill3 = playerSkill3;
    }

    public int getPlayerSkill4() {
        return playerSkill4;
    }

    public void setPlayerSkill4(int playerSkill4) {
        this.playerSkill4 = playerSkill4;
    }

    public int getBaseEnemyLevel() {
        return baseEnemyLevel;
    }

    public void setBaseEnemyLevel(int baseEnemyLevel) {
        this.baseEnemyLevel = baseEnemyLevel;
    }

    public int getAdditionalEnemyLevel() {
        return additionalEnemyLevel;
    }

    public void setAdditionalEnemyLevel(int additionalEnemyLevel) {
        this.additionalEnemyLevel = additionalEnemyLevel;
    }

    public boolean isBattleFlag() {
        return battleFlag;
    }

    public void setBattleFlag(boolean battleFlag) {
        this.battleFlag = battleFlag;
    }

    public int getLastAffrontEnemy() {
        return lastAffrontEnemy;
    }

    public void setLastAffrontEnemy(int lastAffrontEnemy) {
        this.lastAffrontEnemy = lastAffrontEnemy;
    }

    public boolean isPoisonFlag() {
        return poisonFlag;
    }

    public void setPoisonFlag(boolean poisonFlag) {
        this.poisonFlag = poisonFlag;
    }

    public boolean isBleedingFlag() {
        return bleedingFlag;
    }

    public int getFormerPosition() {
        return formerPosition;
    }

    public void setFormerPosition(int formerPosition) {
        this.formerPosition = formerPosition;
    }

    public void setBleedingFlag(boolean bleedingFlag) {
        this.bleedingFlag = bleedingFlag;
    }

    public boolean isEnemyPoisonFlag() {
        return enemyPoisonFlag;
    }

    public void setEnemyPoisonFlag(boolean enemyPoisonFlag) {
        this.enemyPoisonFlag = enemyPoisonFlag;
    }

    public boolean isPlayerAutoHealingFlag() {
        return playerAutoHealingFlag;
    }

    public void setPlayerAutoHealingFlag(boolean playerAutoHealingFlag) {
        this.playerAutoHealingFlag = playerAutoHealingFlag;
    }

    public boolean isPlayerAutoAbsorbingFlag() {
        return playerAutoAbsorbingFlag;
    }

    public void setPlayerAutoAbsorbingFlag(boolean playerAutoAbsorbingFlag) {
        this.playerAutoAbsorbingFlag = playerAutoAbsorbingFlag;
    }

    public boolean isPlayerSuicideFlag() {
        return playerSuicideFlag;
    }

    public void setPlayerSuicideFlag(boolean playerSuicideFlag) {
        this.playerSuicideFlag = playerSuicideFlag;
    }
}