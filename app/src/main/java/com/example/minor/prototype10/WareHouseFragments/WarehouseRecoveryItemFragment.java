package com.example.minor.prototype10.WareHouseFragments;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.RecoveryItemName;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.RecoveryItemAdapter;

import io.realm.Realm;
import io.realm.RealmList;

public class WarehouseRecoveryItemFragment extends Fragment {
    private ListView playerRecoveryItemList, warehouseRecoveryItemList;
    private RecoveryItemAdapter playerRecoveryItemAdapter, warehouseRecoveryItemAdapter;
    private RealmList<RecoveryItemName> playerRecoveryItemNames, warehouseRecoveryItemNames;
    PlayerInfo playerInfo;
    Realm realm;
    private TextView textViewBox, textViewEquipment;
    private ImageButton exchangeButton, decisionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        return inflater.inflate(R.layout.fragment_warehouse_recovery_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TODO: 2018/07/16 RecoveryItemの取得処理を変更する
        exchangeButton = view.findViewById(R.id.exchange_button);
        decisionButton = view.findViewById(R.id.decision_button);
        textViewBox = view.findViewById(R.id.text_warehouse_box);
        textViewEquipment = view.findViewById(R.id.text_warehouse_equipment);
        decisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishThisFragment();
            }
        });

        playerRecoveryItemList = view.findViewById(R.id.warehouse_recovery_item_player);
        playerRecoveryItemNames = playerInfo.getEquippedRecoveryItems();
        playerRecoveryItemAdapter = new RecoveryItemAdapter(playerRecoveryItemNames);
        playerRecoveryItemList.setAdapter(playerRecoveryItemAdapter);
        playerRecoveryItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final RecoveryItemName RecoveryItemName = (RecoveryItemName) parent.getItemAtPosition(position);;

                exchangeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        realm.beginTransaction();
                        warehouseRecoveryItemNames.add(RecoveryItemName);
                        playerRecoveryItemNames.remove(RecoveryItemName);
                        realm.commitTransaction();

                        exchangeButton.setOnClickListener(null);
                    }
                });

            }
        });

        warehouseRecoveryItemList = view.findViewById(R.id.warehouse_recovery_item_box);
        warehouseRecoveryItemNames = playerInfo.getWarehouseRecoveryItems();
        warehouseRecoveryItemAdapter = new RecoveryItemAdapter(warehouseRecoveryItemNames);
        warehouseRecoveryItemList.setAdapter(warehouseRecoveryItemAdapter);

        //倉庫内のアイテムを押されたときの処理を登録しています。
        warehouseRecoveryItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //選択されたアイテムを変数に格納
                final RecoveryItemName RecoveryItemName = (RecoveryItemName) parent.getItemAtPosition(position);

                //交換ボタンが押されたときの処理。
                exchangeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /**
                         * 選択されたアイテムをプレイヤーの持っているリストに追加
                         * 選択されたアイテムを倉庫内のリストから削除
                         */
                        realm.beginTransaction();
                        playerRecoveryItemNames.add(RecoveryItemName);
                        warehouseRecoveryItemNames.remove(RecoveryItemName);
                        realm.commitTransaction();

                        /**
                         * これがないと連打でアイテムが増殖してしまう。
                         */
                        exchangeButton.setOnClickListener(null);
                    }
                });
            }
        });
    }

    public void finishThisFragment(){
        ValueAnimator animator = ValueAnimator.ofInt(180,0);
        animator.setDuration(300);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SuperOnClickMapButton.backgroundImage.setImageAlpha((Integer) valueAnimator.getAnimatedValue());
            }
        });
        animator.start();
        getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).remove(this).commit();
    }
}
