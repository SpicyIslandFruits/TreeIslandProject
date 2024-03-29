package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;
import com.example.minor.prototype10.WareHouseFragments.WarehouseArmorFragment;
import com.example.minor.prototype10.WareHouseFragments.WarehouseOtherItemFragment;
import com.example.minor.prototype10.WareHouseFragments.WarehouseRecoveryItemFragment;
import com.example.minor.prototype10.WareHouseFragments.WarehouseWeaponFragment;

public class OnClickWarehouseButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 14;
        onInit();
        mainText.setText("倉庫は薄暗く、様々なものが散らばっている。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);

        OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
        imageButton8.setOnClickListener(onClickOldMansion1FButton);
        imageButton8Text.setText("戻る");

        if(sharedPreferences.getBoolean("ghostDroppedMoneyFlag", false)){
            //幽霊の落とした貯金箱を拾います。中には自分が今まで井戸に投げ込んだ金額*1.2が入っています。
            mainText.setText("何かが散らばっている。");
            imageButton3Text.setText("拾う");
            imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.soundPool.play(MainActivity.walletSound, 1.0f, 1.0f, 1, 0, 1);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("ghostDroppedMoneyFlag", false);
                    editor.apply();
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() + (int)(playerInfo.getIdoMoneyCount()*1.2));
                    playerInfo.setIdoMoneyCount(0);
                    realm.commitTransaction();
                    resetAllButton();
                    mainText.setText("金だ！\nこれは今まで自分が井戸に投げ込んできたものではないか...\n気のせいか少し増えている気がする...");
                    imageButton8Text.setText("おぉ...");
                    imageButton8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            createMap();
                        }
                    });
                }
            });
        }else {
            imageButton1Text.setText("武器の整理"); //追加
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ValueAnimator animator = ValueAnimator.ofInt(0,180);
                    animator.setDuration(250);
                    animator.setInterpolator(new DecelerateInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            backgroundImage.setImageAlpha((Integer) valueAnimator.getAnimatedValue());
                        }
                    });
                    animator.start();
                    FragmentManager fragmentManager = mMain.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    WarehouseWeaponFragment warehouseWeaponFragment = new WarehouseWeaponFragment();
                    fragmentTransaction.replace(R.id.warehouse_item_fragment, warehouseWeaponFragment);
                    fragmentTransaction.commit();
                }
            });

            imageButton2Text.setText("防具の整理"); //追加
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ValueAnimator animator = ValueAnimator.ofInt(0,180);
                    animator.setDuration(250);
                    animator.setInterpolator(new DecelerateInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            backgroundImage.setImageAlpha((Integer) valueAnimator.getAnimatedValue());
                        }
                    });
                    animator.start();
                    FragmentManager fragmentManager = mMain.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    WarehouseArmorFragment warehouseArmorFragment = new WarehouseArmorFragment();
                    fragmentTransaction.replace(R.id.warehouse_item_fragment, warehouseArmorFragment);
                    fragmentTransaction.commit();
                }
            });

            imageButton3Text.setText("回復薬の整理");
            imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ValueAnimator animator = ValueAnimator.ofInt(0,180);
                    animator.setDuration(250);
                    animator.setInterpolator(new DecelerateInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            backgroundImage.setImageAlpha((Integer) valueAnimator.getAnimatedValue());
                        }
                    });
                    animator.start();
                    FragmentManager fragmentManager = mMain.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    WarehouseRecoveryItemFragment warehouseRecoveryItemFragment = new WarehouseRecoveryItemFragment();
                    fragmentTransaction.replace(R.id.warehouse_item_fragment, warehouseRecoveryItemFragment);
                    fragmentTransaction.commit();
                }
            });

            imageButton4Text.setText("その他の整理");
            imageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ValueAnimator animator = ValueAnimator.ofInt(0,180);
                    animator.setDuration(250);
                    animator.setInterpolator(new DecelerateInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            backgroundImage.setImageAlpha((Integer) valueAnimator.getAnimatedValue());
                        }
                    });
                    animator.start();
                    FragmentManager fragmentManager = mMain.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    WarehouseOtherItemFragment warehouseOtherItemFragment = new WarehouseOtherItemFragment();
                    fragmentTransaction.replace(R.id.warehouse_item_fragment, warehouseOtherItemFragment);
                    fragmentTransaction.commit();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        stopAllButtons();
        createMap();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAllButtons();
            }
        }, 1000);
    }
}
