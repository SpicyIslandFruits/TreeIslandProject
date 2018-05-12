package com.example.minor.prototype10.OnClickMapButtons;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBurankoNisuwaruButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 24;
        savePosition();
        resetAllButtons();

        //初めてブランコに座る場合
        if(sharedPreferences.getInt("oldMansionGardenBurankoState", 0) == 0) {

            OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
            imageButton8.setOnClickListener(onClickGardenButton);

            stopAllButtons();
            mainText.setText("");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("oldMansionGardenBurankoState", 1);
            editor.apply();
            MainActivity.soundPool.play(MainActivity.woodBrokenSound, 1.0f, 1.0f, 1, 0, 1);

            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startAllButtons();
                    imageButton8Text.setText("諦める");
                    mainText.setText("ブランコが壊れてしまった...。\n鉄がサビていたようだ。");
                }
            }, 2000);
        }else if(sharedPreferences.getInt("oldMansionGardenBurankoState", 0) == 1){
            MainActivity.soundPool.play(MainActivity.oldWoodenDoorSound, 1.0f, 1.0f, 1, 0, 1);
            OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
            imageButton8.setOnClickListener(onClickGardenButton);
            imageButton8Text.setText("諦める");
            mainText.setText("持ち手がちぎれてしまっている。\nこのままでは座れない...。");
        }else if(sharedPreferences.getInt("oldMansionGardenBurankoState", 0) == 2){
            //中身が未定、謎解きマップにします
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
