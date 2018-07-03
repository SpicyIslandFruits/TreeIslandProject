package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickBenchButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 21;
        onInit();
        resetAllButtons();
        //ベンチの状態にあわせて文章を買えます
        if (sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 0) {
            mainText.setText("今にも壊れそうなベンチがぽつんと置かれている。");
        }else if (sharedPreferences.getInt("oldMansionGardenBenchState",0) == 1){
            mainText.setText("座るところが抜けて骨組みがむき出しになっている。");
        }else if (sharedPreferences.getInt("oldMansionGardenBenchState",0) == 2){
            mainText.setText("自分で修理したからか、既製品よりも愛着がわいてくる。");
        }
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickBenchNisuwaruButton onClickBenchNisuwaruButton = new OnClickBenchNisuwaruButton();
        imageButton1.setOnClickListener(onClickBenchNisuwaruButton);
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
