package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickEvtWarehouseButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 36;
        savePosition();
        resetAllButtons();
        mainText.setText("ここに隠れているのだろうか...");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1Text.setText("探す");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1.setEnabled(false);
                imageButton1Text.setText("");
                mainText.setText("");
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 0.5f);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("戻る");
                        mainText.setText("ここにはいないようだ...");
                    }
                }, 1500);
            }
        });
        // 戻ろうとしたら幽霊が出てくるシーンです、最終的に部屋を出るときsharedPreferenceのitemDroppedByGhostFlagをtrueに変え、アイテムを拾わせます。
        // 今まで井戸に投げ込んできたお金が1.2倍になって帰ってきます。
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.soundPool.play(MainActivity.glassBreakSound, 1.0f, 1.0f, 1, 0, 0.5f);
                    }
                }, 600);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("！！！");
                    }
                }, 1000);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("何かがお前の横を通り過ぎ、二階へと吸い込まれていくのが見えた。\nあまりに一瞬の出来事に、お前は反応することができなかった...");
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("oldMansionGhostPosition", 2);
                        editor.putBoolean("ghostDroppedMoneyFlag", true);
                        editor.apply();
                        startAllButtons();
                        OnClickEvtMansion1FButton onClickEvtMansion1FButton = new OnClickEvtMansion1FButton();
                        imageButton8.setOnClickListener(onClickEvtMansion1FButton);
                        imageButton8Text.setText("追いかける");
                    }
                }, 2000);
            }
        });
        imageButton8Text.setText("戻る");
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
