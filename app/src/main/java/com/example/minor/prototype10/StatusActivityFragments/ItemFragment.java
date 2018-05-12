package com.example.minor.prototype10.StatusActivityFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minor.prototype10.ImportantItemAdapter;
import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.MakeData;
import com.example.minor.prototype10.Models.ImportantItemId;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.WeaponAdapter;

import io.realm.Realm;
import io.realm.RealmResults;

public class ItemFragment extends Fragment {
    private Realm realm;
    private MakeData makeData;
    private ListView recoveryItemList, amuletList, importantItemList, rawMaterialsList;
    //後三つ追加します。
    private TextView selectedImportantItem;
    private RealmResults<ImportantItemId> importantItemIds;
    private ImportantItemId importantItemIdInstance;
    private String importantItemName;
    private ImageButton useRecoveryItemButton, useImportantItemButton;
    private SuperItem item;
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
        makeData = new MakeData();
        recoveryItemList = view.findViewById(R.id.recovery_item_list);
        amuletList = view.findViewById(R.id.amulet_list);
        importantItemList = view.findViewById(R.id.important_item_list);
        rawMaterialsList = view.findViewById(R.id.raw_materials_list);
        //四つ分やる
        selectedImportantItem = view.findViewById(R.id.selected_important_item);

        //回復薬の分もやる
        useImportantItemButton = view.findViewById(R.id.use_important_item_button);

        //四つのリストビューの分やる。
        importantItemIds = realm.where(ImportantItemId.class).findAll();
        importantItemAdapter = new ImportantItemAdapter(importantItemIds);
        importantItemList.setAdapter(importantItemAdapter);

        importantItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                importantItemIdInstance = (ImportantItemId) parent.getItemAtPosition(position);
                importantItemName = importantItemIdInstance.getItemName();
                item = makeData.makeItemFromName(importantItemName);
                selectedImportantItem.setText(item.getName() + "\n" + item.getInformation());
                useImportantItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        item.useMaterial();
                    }
                });
            }
        });
    }
}
