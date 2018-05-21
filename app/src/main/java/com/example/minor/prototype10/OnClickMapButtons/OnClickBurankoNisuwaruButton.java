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
            if(sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 2 && !sharedPreferences.getBoolean("BBBothRepairedEvtDoneFlag", false)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("BBBothRepairedEvtDoneFlag", true);
                editor.apply();
                //中身未定、謎解きマップにします、幽霊が現れる
                OnClickBBBothRepairedEvtButton onClickBBBothRepairedEvtButton = new OnClickBBBothRepairedEvtButton();
                imageButton1.setOnClickListener(onClickBBBothRepairedEvtButton);
                imageButton1Text.setText("おや？");
                mainText.setText("ベンチの材料とブランコの材料を共に使用しました。\nイベントは未定です。\n文章未定");
            }else if(!sharedPreferences.getBoolean("BBEitherOneRepairedEvtDoneFlag", false) && !sharedPreferences.getBoolean("BBBothRepairedEvtDoneFlag", false) ){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("BBEitherOneRepairedEvtDoneFlag", true);
                editor.apply();
                OnClickBBEitherOneRepairedEvtButton onClickBBEitherOneRepairedEvtButton = new OnClickBBEitherOneRepairedEvtButton();
                imageButton1.setOnClickListener(onClickBBEitherOneRepairedEvtButton);
                imageButton1Text.setText("おや？");
                mainText.setText("ベンチとブランコのうち片方を修理しました。\n幽霊の声が聞こえます。\n文章未定");
            }else{
                //普通にブランコに座った時の処理です
                OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
                imageButton8.setOnClickListener(onClickGardenButton);
                imageButton8Text.setText("戻る");
                mainText.setText("ブランコに座った\n文章未定");
            }
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
