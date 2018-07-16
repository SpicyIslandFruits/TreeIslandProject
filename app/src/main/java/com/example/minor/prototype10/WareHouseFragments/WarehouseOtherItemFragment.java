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
import com.example.minor.prototype10.Models.OtherItemName;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.Adapters.OtherItemAdapter;

import io.realm.Realm;
import io.realm.RealmList;

public class WarehouseOtherItemFragment extends Fragment {
    private ListView playerOtherItemList, warehouseOtherItemList;
    private OtherItemAdapter playerOtherItemAdapter, warehouseOtherItemAdapter;
    private RealmList<OtherItemName> playerOtherItemNames, warehouseOtherItemNames;
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
        return inflater.inflate(R.layout.fragment_warehouse_other_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TODO: 2018/07/16 OtherItemの取得処理を変更する
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

        playerOtherItemList = view.findViewById(R.id.warehouse_other_item_player);
        playerOtherItemNames = playerInfo.getEquippedOtherItems();
        playerOtherItemAdapter = new OtherItemAdapter(playerOtherItemNames);
        playerOtherItemList.setAdapter(playerOtherItemAdapter);
        playerOtherItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final OtherItemName OtherItemName = (OtherItemName) parent.getItemAtPosition(position);;

                exchangeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        realm.beginTransaction();
                        warehouseOtherItemNames.add(OtherItemName);
                        playerOtherItemNames.remove(OtherItemName);
                        realm.commitTransaction();

                        exchangeButton.setOnClickListener(null);
                    }
                });

            }
        });

        warehouseOtherItemList = view.findViewById(R.id.warehouse_other_item_box);
        warehouseOtherItemNames = playerInfo.getWarehouseOtherItems();
        warehouseOtherItemAdapter = new OtherItemAdapter(warehouseOtherItemNames);
        warehouseOtherItemList.setAdapter(warehouseOtherItemAdapter);

        //倉庫内のアイテムを押されたときの処理を登録しています。
        warehouseOtherItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //選択されたアイテムを変数に格納
                final OtherItemName OtherItemName = (OtherItemName) parent.getItemAtPosition(position);

                //交換ボタンが押されたときの処理。
                exchangeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /**
                         * 選択されたアイテムをプレイヤーの持っているリストに追加
                         * 選択されたアイテムを倉庫内のリストから削除
                         */
                        realm.beginTransaction();
                        playerOtherItemNames.add(OtherItemName);
                        warehouseOtherItemNames.remove(OtherItemName);
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
