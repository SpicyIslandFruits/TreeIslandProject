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

import com.example.minor.prototype10.Adapters.AmuletAdapter;
import com.example.minor.prototype10.Adapters.ImportantItemAdapter;
import com.example.minor.prototype10.Adapters.OtherItemAdapter;
import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.MakeData;
import com.example.minor.prototype10.Models.AmuletName;
import com.example.minor.prototype10.Models.ImportantItemName;
import com.example.minor.prototype10.Models.OtherItemName;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.RecoveryItemName;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.Adapters.RecoveryItemAdapter;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * TODO: これからrealm.where(~.class).findAllをplayerInfo.getEquipped~に変えていきます。
 * OtherItemについてやる
 */
public class ItemFragment extends Fragment {
    private Realm realm;
    private MakeData makeData;
    private ListView recoveryItemList, amuletList, importantItemList, otherItemList;
    //後三つ追加します。
    private TextView selectedImportantItemText, selectedRecoveryItemText, selectedAmuletText, selectedOtherItemText;
    private RealmResults<ImportantItemName> importantItemNames;
    private RealmList<RecoveryItemName> recoveryItemNames;
    private RealmResults<AmuletName> amuletNames;
    private RealmList<OtherItemName> otherItemNames;
    private ImportantItemName importantItemNameInstance;
    private RecoveryItemName recoveryItemNameInstance;
    private AmuletName amuletNameInstance;
    private OtherItemName otherItemNameInstance;
    private String importantItemName, recoveryItemName, amuletName, otherItemName;
    private ImageButton useRecoveryItemButton, useImportantItemButton;
    private SuperItem item;
    private ImportantItemAdapter importantItemAdapter;
    private RecoveryItemAdapter recoveryItemAdapter;
    private AmuletAdapter amuletAdapter;
    private OtherItemAdapter otherItemAdapter;
    private PlayerInfo playerInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        makeData = new MakeData();
        recoveryItemList = view.findViewById(R.id.recovery_item_list);
        amuletList = view.findViewById(R.id.amulet_list);
        importantItemList = view.findViewById(R.id.important_item_list);
        otherItemList = view.findViewById(R.id.other_items_list);
        /**
         * リストビューの取得。
         */
        selectedImportantItemText = view.findViewById(R.id.selected_important_item);
        selectedRecoveryItemText = view.findViewById(R.id.selected_recovery_item);
        selectedAmuletText = view.findViewById(R.id.selected_amulet);
        selectedOtherItemText = view.findViewById(R.id.selected_other_item);

        /**
         * 回復と大切なものについては使用するのでボタンがいる。
         */
        useImportantItemButton = view.findViewById(R.id.use_important_item_button);
        useRecoveryItemButton = view.findViewById(R.id.use_recovery_item_button);

        /**
         * リストビューにアダプターをセット。
         * 回復とその他のアイテムについては倉庫で処理できるようにplayerInfoにaddしているのでそれを取得します。
         */
        //大切なもののリスト
        importantItemNames = realm.where(ImportantItemName.class).findAll();
        importantItemAdapter = new ImportantItemAdapter(importantItemNames);
        importantItemList.setAdapter(importantItemAdapter);
        //回復アイテムのリスト
        recoveryItemNames = playerInfo.getEquippedRecoveryItems();
        recoveryItemAdapter = new RecoveryItemAdapter(recoveryItemNames);
        recoveryItemList.setAdapter(recoveryItemAdapter);
        //その他のアイテムのリスト
        otherItemNames = playerInfo.getEquippedOtherItems();
        otherItemAdapter = new OtherItemAdapter(otherItemNames);
        otherItemList.setAdapter(otherItemAdapter);
        //装飾品のリスト
        amuletNames = realm.where(AmuletName.class).findAll();
        amuletAdapter = new AmuletAdapter(amuletNames);
        amuletList.setAdapter(amuletAdapter);

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

        amuletList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                amuletNameInstance = (AmuletName) parent.getItemAtPosition(position);
                amuletName = amuletNameInstance.getAmuletName();
                item = makeData.makeItemFromName(amuletName);
                selectedAmuletText.setText(item.getName() + "\n" + item.getInformation());
            }
        });

        otherItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                otherItemNameInstance = (OtherItemName) parent.getItemAtPosition(position);
                otherItemName = otherItemNameInstance.getOtherItemName();
                item = makeData.makeItemFromName(otherItemName);
                selectedOtherItemText.setText(item.getName() + "\n" + item.getInformation());
            }
        });
    }
}
