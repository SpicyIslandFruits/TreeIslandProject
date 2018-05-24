package com.example.minor.prototype10.OnClickMapButtons;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;

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
            imageButton1Text.setText("拾う");
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    //editor.putBoolean("ghostDroppedMoneyFlag", false);
                    editor.apply();
                    mainText.setText("拾う処理は未実装です");
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
