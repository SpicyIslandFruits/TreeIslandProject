package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickBurankoButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 23;
        onInit();
        resetAllButtons();
        if (sharedPreferences.getInt("oldMansionGardenBurankoState", 0) == 0) {
            mainText.setText("錆びれたブランコが置かれている。");
        }else if (sharedPreferences.getInt("oldMansionGardenBurankoState",0) == 1){
            mainText.setText("持ち手がちぎれてしまっている。");
        }else if (sharedPreferences.getInt("oldMansionGardenBurankoState",0) == 2){
            mainText.setText("自分で修理したからか、既製品よりも愛着がわいてくる。");
        }
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickBurankoNisuwaruButton onClickBurankoNisuwaruButton = new OnClickBurankoNisuwaruButton();
        imageButton1.setOnClickListener(onClickBurankoNisuwaruButton);
        imageButton1Text.setText("座る");
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
        imageButton8Text.setText("やめる");
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
