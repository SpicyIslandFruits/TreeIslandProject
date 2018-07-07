package com.example.minor.prototype10.WareHouseFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponName;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.WeaponAdapter;

import io.realm.Realm;
import io.realm.RealmList;

public class WareHouseWeaponFragment extends Fragment {
    private ListView playerWeaponList, warehouseWeaponList;
    private WeaponAdapter playerWeaponAdapter, warehouseWeaponAdapter;
    private RealmList<WeaponName> playerWeaponNames, warehouseWeaponNames;
    private Realm realm;
    private PlayerInfo playerInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        return inflater.inflate(R.layout.fragment_ware_house_weapon, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * Todo: ボタンの処理を変える。
         */
        playerWeaponList = view.findViewById(R.id.warehouse_weapon_player);
        playerWeaponNames = playerInfo.getEquippedWeapons();
        playerWeaponAdapter = new WeaponAdapter(playerWeaponNames);
        playerWeaponList.setAdapter(playerWeaponAdapter);
        playerWeaponList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                realm.beginTransaction();
                warehouseWeaponNames.add((WeaponName) parent.getItemAtPosition(position));
                playerWeaponNames.remove(parent.getItemAtPosition(position));
                realm.commitTransaction();
            }
        });

        /**
         *
         */
        warehouseWeaponList = view.findViewById(R.id.warehouse_weapon_box);
        warehouseWeaponNames = playerInfo.getWarehouseWeapons();
        warehouseWeaponAdapter = new WeaponAdapter(warehouseWeaponNames);
        warehouseWeaponList.setAdapter(warehouseWeaponAdapter);
        warehouseWeaponList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                realm.beginTransaction();
                playerWeaponNames.add((WeaponName) parent.getItemAtPosition(position));
                warehouseWeaponNames.remove(parent.getItemAtPosition(position));
                realm.commitTransaction();

            }
        });
    }
}
