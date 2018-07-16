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
import com.example.minor.prototype10.Models.ArmorName;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.ArmorAdapter;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Todo: 装備中の武具は表示しない、または移動できないようにする。
 * Todo: 武器、アイテム、素材についても同様に作る。
 */
public class WarehouseArmorFragment extends Fragment {
    private ListView playerArmorList, warehouseArmorList;
    private ArmorAdapter playerArmorAdapter, warehouseArmorAdapter;
    private RealmList<ArmorName> playerArmorNames, warehouseArmorNames;
    private Realm realm;
    private PlayerInfo playerInfo;
    private TextView textViewBox, textViewEquipment;
    private ImageButton exchangeButton, decisionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        return inflater.inflate(R.layout.fragment_warehouse_armor, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        exchangeButton = view.findViewById(R.id.exchange_button);
        decisionButton = view.findViewById(R.id.decision_button);
        textViewBox = view.findViewById(R.id.text_warehouse_box);
        textViewEquipment = view.findViewById(R.id.text_warehouse_equipment);

        textViewBox.setText("倉庫");
        textViewEquipment.setText("持ち物");

        decisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishThisFragment();
            }
        });

        playerArmorList = view.findViewById(R.id.warehouse_armor_player);
        playerArmorNames = playerInfo.getEquippedArmors();
        playerArmorAdapter = new ArmorAdapter(playerArmorNames);
        playerArmorList.setAdapter(playerArmorAdapter);
        playerArmorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final ArmorName armorName = (ArmorName) parent.getItemAtPosition(position);;

                exchangeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        realm.beginTransaction();
                        warehouseArmorNames.add(armorName);
                        playerArmorNames.remove(armorName);
                        realm.commitTransaction();

                        exchangeButton.setOnClickListener(null);
                    }
                });

            }
        });

        warehouseArmorList = view.findViewById(R.id.warehouse_armor_box);
        warehouseArmorNames = playerInfo.getWarehouseArmors();
        warehouseArmorAdapter = new ArmorAdapter(warehouseArmorNames);
        warehouseArmorList.setAdapter(warehouseArmorAdapter);

        //倉庫内のアイテムが押されたときの処理を登録しています。
        warehouseArmorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //選択されたアイテムを変数に格納
                final ArmorName armorName = (ArmorName) parent.getItemAtPosition(position);

                //交換ボタンが押されたときの処理。
                exchangeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        realm.beginTransaction();
                        playerArmorNames.add(armorName);
                        warehouseArmorNames.remove(armorName);
                        realm.commitTransaction();

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
