package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickBurankoNisuwaruButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 24;
        onInit();

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
            mainText.setText("このままでは座れない...。");
        }else if(sharedPreferences.getInt("oldMansionGardenBurankoState", 0) == 2){
            if(sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 2 && !sharedPreferences.getBoolean("BBBothRepairedEvtDoneFlag", false)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("BBBothRepairedEvtDoneFlag", true);
                editor.apply();

                String bgmName = "nightSound";
                mediaPlayer = MediaPlayer.create(mMain, R.raw.night_sound);
                audioPlay(mediaPlayer, bgmName);
                mainText.setText("お前はブランコに座った。\nこれで修理は終わった。\n自分の住んでいる家がボロボロなのは気にくわないのだ。\nなかなか大変だった...");
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageButton8.setEnabled(false);
                        imageButton8Text.setText("");
                        MainActivity.soundPool.play(MainActivity.warauSound, 1.0f, 1.0f, 1, 0, 1);
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                OnClickBBBothRepairedEvtButton onClickBBBothRepairedEvtButton = new OnClickBBBothRepairedEvtButton();
                                imageButton1.setOnClickListener(onClickBBBothRepairedEvtButton);
                                imageButton1Text.setText("立ち上がる");
                                mainText.setText("！！！");
                            }
                        }, 1500);
                    }
                });
                imageButton8Text.setText("黄昏る");
            }else if(!sharedPreferences.getBoolean("BBEitherOneRepairedEvtDoneFlag", false) && !sharedPreferences.getBoolean("BBBothRepairedEvtDoneFlag", false) ){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("BBEitherOneRepairedEvtDoneFlag", true);
                editor.apply();

                String bgmName = "nightSound";
                mediaPlayer = MediaPlayer.create(mMain, R.raw.night_sound);
                audioPlay(mediaPlayer, bgmName);
                mainText.setText("お前はブランコに座った。\n以外に大変な作業だった。\n庭はとても静かで風が心地いい、\nブランコに揺られているうちにお前は眠くなってきて...");
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageButton8.setEnabled(false);
                        imageButton8Text.setText("");
                        mainText.setText("");
                        MainActivity.soundPool.play(MainActivity.warauSound, 1.0f, 1.0f, 1, 0, 1);
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                OnClickBBEitherOneRepairedEvtButton onClickBBEitherOneRepairedEvtButton = new OnClickBBEitherOneRepairedEvtButton();
                                imageButton1.setOnClickListener(onClickBBEitherOneRepairedEvtButton);
                                imageButton1Text.setText("振り向く");
                                mainText.setText("！！！");
                            }
                        }, 1500);
                    }
                });
                imageButton8Text.setText("眠ろう...");
            }else{
                //普通にブランコに座った時の処理です
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
                imageButton8.setOnClickListener(onClickGardenButton);
                imageButton8Text.setText("戻る");
                mainText.setText("お前はブランコに揺られながら、目を閉じた。\n父は、きっと無事では済まないだろう。考えれば考えるほど不安で胸が落ち着かなくなる...\nだが今のお前は自分の身の上のことで精いっぱいなのだ。");
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
