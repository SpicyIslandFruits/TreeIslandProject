package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickWarehouseButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 14;
        savePosition();
        resetAllButtons();
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
                    mainText.setText("金だ！\nこれは今まで自分が井戸に投げ込んできたものではないか...\n気のせいか少し増えている気がする...");
                    imageButton3.setOnClickListener(null);
                    imageButton3Text.setText("");
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
