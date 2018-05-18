package com.example.minor.prototype10.StatusActivityFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minor.prototype10.ArmorAdapter;
import com.example.minor.prototype10.Armors.SuperArmor;
import com.example.minor.prototype10.MakeData;
import com.example.minor.prototype10.Models.ArmorName;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.WeaponAdapter;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * view.findViewById書く
 * インターフェースを見直す
 * 防具についても同様
 */

public class EquipmentFragment extends Fragment {
    private Realm realm;
    private RealmResults<WeaponId> weaponIds;
    private RealmResults<ArmorName> armorNames;
    private WeaponId weaponIdInstance;
    private ArmorName armorNameInstance;
    private MakeData makeData;
    private SuperWeapon weapon;
    private SuperArmor armor;
    private PlayerInfo playerInfo;
    private WeaponAdapter weaponAdapter;
    private ArmorAdapter armorAdapter;
    private ListView weaponList, armorList;
    private TextView equipedWeapon, weaponNameText, weaponATK, weaponSkill1, weaponSkill2, weaponSkill3;
    private TextView equipedArmor, armorNameText, armorDF, armorSkill1, armorSkill2, armorSkill3;
    //後で消します。
    private int weaponId, armorId;
    private String armorName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        return inflater.inflate(R.layout.fragment_equipment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        makeData = new MakeData();
        weaponList = view.findViewById(R.id.weapon_list);
        armorList = view.findViewById(R.id.armor_list);
        equipedWeapon = view.findViewById(R.id.equiped_weapon);
        weaponNameText = view.findViewById(R.id.weapon_name);
        equipedArmor = view.findViewById(R.id.equiped_armor);
        armorNameText = view.findViewById(R.id.armor_name);
        weaponATK = view.findViewById(R.id.weapon_atk);
        armorDF = view.findViewById(R.id.armor_df);
        weaponSkill1 = view.findViewById(R.id.weapon_skill1);
        weaponSkill2 = view.findViewById(R.id.weapon_skill2);
        weaponSkill3 = view.findViewById(R.id.weapon_skill3);
        armorSkill1 = view.findViewById(R.id.armor_skill1);
        armorSkill2 = view.findViewById(R.id.armor_skill2);
        armorSkill3 = view.findViewById(R.id.armor_skill3);
        weaponIds = realm.where(WeaponId.class).findAll();
        armorNames = realm.where(ArmorName.class).findAll();
        weaponAdapter = new WeaponAdapter(weaponIds);
        armorAdapter = new ArmorAdapter(armorNames);
        weaponList.setAdapter(weaponAdapter);
        armorList.setAdapter(armorAdapter);

        //これと同じことを防具の場合にも行う
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        weaponId = playerInfo.getWeaponId();
        weapon = makeData.makeWeaponFromId(weaponId);
        weaponIdInstance = realm.where(WeaponId.class).equalTo("weaponId", weaponId).findFirst();
        weaponNameText.setText(weapon.getName());
        equipedWeapon.setText(weapon.getName());
        weaponATK.setText("攻撃力:"+String.valueOf(weaponIdInstance.getWeaponAtk()));
        weaponSkill1.setText(weapon.getSkill1Info());
        weaponSkill2.setText(weapon.getSkill2Info());
        weaponSkill3.setText(weapon.getSkill3Info());
        //これと同じことを防具の場合にも行う

        weaponList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                weaponIdInstance = (WeaponId) parent.getItemAtPosition(position);
                weaponId = weaponIdInstance.getWeaponId();
                weapon = makeData.makeWeaponFromId(weaponId);
                equipedWeapon.setText(weapon.getName());
                weaponNameText.setText(weapon.getName());
                weaponATK.setText("攻撃力:"+String.valueOf(weaponIdInstance.getWeaponAtk()));
                weaponSkill1.setText(weapon.getSkill1Info());
                weaponSkill2.setText(weapon.getSkill2Info());
                weaponSkill3.setText(weapon.getSkill3Info());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        playerInfo = realm.where(PlayerInfo.class).findFirst();
                        playerInfo.setWeaponId(weaponId);
                        playerInfo.setfATK(weaponIdInstance.getWeaponAtk());
                    }
                });
            }
        });

        armorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                armorNameInstance = (ArmorName) parent.getItemAtPosition(position);
                armorName = armorNameInstance.getArmorName();
                equipedArmor.setText(armorName);
                armorNameText.setText(armorName);
                armorDF.setText("防御力:"+String.valueOf(armorNameInstance.getArmorDf()));
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        playerInfo = realm.where(PlayerInfo.class).findFirst();
                        playerInfo.setfDF(armorNameInstance.getArmorDf());
                    }
                });
            }
        });
    }
}