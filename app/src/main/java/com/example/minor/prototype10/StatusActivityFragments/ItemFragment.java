package com.example.minor.prototype10.StatusActivityFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.minor.prototype10.ImportantItemAdapter;
import com.example.minor.prototype10.Models.ImportantItemId;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.WeaponAdapter;

import io.realm.Realm;
import io.realm.RealmResults;

public class ItemFragment extends Fragment {
    private Realm realm;
    private ListView recoveryItemList, amuletList, importantItemList, rawMaterialsList;
    //後三つ追加します。
    private RealmResults<ImportantItemId> importantItemIds;
    private ImageButton useRecoveryItemButton;
    private ImportantItemAdapter importantItemAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recoveryItemList = view.findViewById(R.id.recovery_item_list);
        amuletList = view.findViewById(R.id.amulet_list);
        importantItemList = view.findViewById(R.id.important_item_list);
        rawMaterialsList = view.findViewById(R.id.raw_materials_list);

        //四つのリストビューの分やる。
        importantItemIds = realm.where(ImportantItemId.class).findAll();
        importantItemAdapter = new ImportantItemAdapter(importantItemIds);
        importantItemList.setAdapter(importantItemAdapter);

    }
}
