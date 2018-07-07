package com.example.minor.prototype10.WareHouseFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.minor.prototype10.Models.WeaponName;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.WeaponAdapter;

import io.realm.Realm;
import io.realm.RealmResults;

public class WareHouseWeaponFragment extends Fragment {
    private ListView weaponList;
    private WeaponAdapter weaponAdapter;
    private RealmResults<WeaponName> weaponNames;
    private Realm realm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        return inflater.inflate(R.layout.fragment_ware_house_weapon, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        weaponList = view.findViewById(R.id.warehouse_weapon_player);
        weaponNames = realm.where(WeaponName.class).findAll();
        weaponAdapter = new WeaponAdapter(weaponNames);
        weaponList.setAdapter(weaponAdapter);
        weaponList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
