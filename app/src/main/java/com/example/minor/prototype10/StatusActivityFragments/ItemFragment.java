package com.example.minor.prototype10.StatusActivityFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minor.prototype10.ImportantItemAdapter;
import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.MakeData;
import com.example.minor.prototype10.Models.ImportantItemName;
import com.example.minor.prototype10.Models.RecoveryItemName;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.RecoveryItemAdapter;

import io.realm.Realm;
import io.realm.RealmResults;

public class ItemFragment extends Fragment {
    private Realm realm;
    private MakeData makeData;
    private ListView recoveryItemList, amuletList, importantItemList, rawMaterialsList;
    //後三つ追加します。
    private TextView selectedImportantItemText, selectedRecoveryItemText;
    private RealmResults<ImportantItemName> importantItemNames;
    private RealmResults<RecoveryItemName> recoveryItemNames;
    private ImportantItemName importantItemNameInstance;
    private RecoveryItemName recoveryItemNameInstance;
    private String importantItemName, recoveryItemName;
    private ImageButton useRecoveryItemButton, useImportantItemButton;
    private SuperItem item;
    private ImportantItemAdapter importantItemAdapter;
    private RecoveryItemAdapter recoveryItemAdapter;

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
        selectedImportantItemText = view.findViewById(R.id.selected_important_item);
        selectedRecoveryItemText = view.findViewById(R.id.selected_recovery_item);

        //回復薬の分もやる
        useImportantItemButton = view.findViewById(R.id.use_important_item_button);
        useRecoveryItemButton = view.findViewById(R.id.use_recovery_item_button);

        //四つのリストビューの分やる。
        //大切なもののリスト
        importantItemNames = realm.where(ImportantItemName.class).findAll();
        importantItemAdapter = new ImportantItemAdapter(importantItemNames);
        importantItemList.setAdapter(importantItemAdapter);
        //回復アイテムのリスト
        recoveryItemNames = realm.where(RecoveryItemName.class).findAll();
        recoveryItemAdapter = new RecoveryItemAdapter(recoveryItemNames);
        recoveryItemList.setAdapter(recoveryItemAdapter);

        importantItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                importantItemNameInstance = (ImportantItemName) parent.getItemAtPosition(position);
                importantItemName = importantItemNameInstance.getItemName();
                item = makeData.makeItemFromName(importantItemName);
                selectedImportantItemText.setText(item.getName() + "\n" + item.getInformation());
                useImportantItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        item.useMaterial();
                        selectedImportantItemText.setText("");
                    }
                });
            }
        });

        recoveryItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                recoveryItemNameInstance = (RecoveryItemName) parent.getItemAtPosition(position);
                recoveryItemName = recoveryItemNameInstance.getItemName();
                item = makeData.makeItemFromName(recoveryItemName);
                selectedRecoveryItemText.setText(item.getName() + "\n" + item.getInformation());
                useRecoveryItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        item.useRecoveryItem();
                        selectedRecoveryItemText.setText("");
                    }
                });
            }
        });
    }
}
