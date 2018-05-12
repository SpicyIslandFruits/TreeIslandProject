package com.example.minor.prototype10.OnClickMapButtons;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBenchNisuwaruButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 22;
        savePosition();
        resetAllButtons();

        //初めてベンチに座る場合
        if(sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 0) {

            OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
            imageButton8.setOnClickListener(onClickGardenButton);

            stopAllButtons();
            mainText.setText("");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("oldMansionGardenBenchState", 1);
            editor.apply();
            MainActivity.soundPool.play(MainActivity.woodBrokenSound, 1.0f, 1.0f, 1, 0, 1);

            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startAllButtons();
                    imageButton8Text.setText("諦める");
                    mainText.setText("ベンチが壊れてしまった...。\n木が腐っていたようだ。");
                }
            }, 2000);
        }else if(sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 1){
            MainActivity.soundPool.play(MainActivity.oldWoodenDoorSound, 1.0f, 1.0f, 1, 0, 1);
            OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
            imageButton8.setOnClickListener(onClickGardenButton);
            imageButton8Text.setText("諦める");
            mainText.setText("座るところが抜けて骨組みがむき出しになっている。\nこのままでは座れない...。");
        }else if(sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 2){
            //中身未定、謎解きマップにします
            OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
            imageButton8.setOnClickListener(onClickGardenButton);
            imageButton8Text.setText("戻る");
            mainText.setText("ベンチの材料を使用しました。\nイベントは未定です。");
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
